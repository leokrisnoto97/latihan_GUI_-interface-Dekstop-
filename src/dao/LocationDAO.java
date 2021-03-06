/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Country;
import model.Location;

/**
 *
 * @author chochong
 */
public class LocationDAO {

    private Connection koneksi;
    private CountryDAO cdao;

    /**
     * Constructur kosong untuk di gunakan pada Fungsi atau Method lain.
     */
    public LocationDAO() {

    }

    /**
     * method untuk mendapatkan koneksi ke Database
     *
     * @return get koneksi
     */
    public Connection getKoneksi() {
        return koneksi;
    }

    /**
     * Constructur untuk membuat LocationDAO memiliki Koneksi
     *
     * @param koneksi untuk mendapatkan Koneksi antara LocationDAO dan
     * CountryDAO
     */
    public LocationDAO(Connection koneksi) {
        this.koneksi = koneksi;
        this.cdao = new CountryDAO(koneksi);
    }

    /**
     * Method untuk meng'eksekusi'kan query yang bersifat perintah dapat
     * di gunakan untuk fungsi lain
     *
     * @param sql untuk di isi dengan query perintah pada fungsi perintah
     * @return get hasil eksekusi
     */
    public boolean eksekusi(String sql) {
        boolean hasil = false;
        try {
            PreparedStatement statment = koneksi.prepareStatement(sql);
            statment.execute();
            hasil = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return hasil;
    }

    /**
     * Untuk membuat ID dalam case ini merupakan Primary Key menjadi Otomatis
     * bertambah Sesuai dengan tabel database masing masing
     *
     * @return berisi hasil dari data yang diambil sesuai query yang dibuat
     */
    public int autoId() {
        return this.getData("select max(LOCATION_ID)+100 LOCATION_ID, max(STREET_ADDRESS) STREET_ADDRESS, "
                + "max(POSTAL_CODE) POSTAL_CODE, max(CITY) CITY, max(STATE_PROVINCE) STATE_PROVINCE, "
                + "max(COUNTRY_ID) COUNTRY_ID from locations").get(0).getLocation_id();
    }

    /**
     * Untuk mendapatkan Data dari tabel Database yang dipakai dan
     * mendeklarasikan sebuah (set) menyesuaikan dengan kolom database
     *
     * @param sql Di isi dengan query yang akan di lakukan
     * @return Mengembalikan data Locations seperti semula
     */
    public List<Location> getData(String sql) {
        List<Location> locations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocation_id(resultSet.getInt("LOCATION_ID"));
                location.setStreet_address(resultSet.getString("STREET_ADDRESS"));
                location.setPostal_code(resultSet.getString("POSTAL_CODE"));
                location.setCity(resultSet.getString("CITY"));
                location.setState_province(resultSet.getString("STATE_PROVINCE"));
                Country country = cdao.getById(resultSet.getString("COUNTRY_ID")).get(0);
                location.setCountry_id(country);
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return locations;
    }

    /**
     * Method untuk melakukan Insert atau Simpan data baru pada Tabel Locations
     *
     * @param location berisi data yang akan di Simpan
     * @return Mengembalikan data location
     */
    public boolean simpanLocation(Location location) {
        int locationId = this.autoId();
        System.out.println(location.getCountry_id() == null);
        System.out.println(locationId);
        return this.eksekusi("insert into locations values ("
                + locationId
                + ",'" + location.getStreet_address()
                + "','" + location.getPostal_code()
                + "','" + location.getCity()
                + "','" + location.getState_province()
                + "','" + location.getCountry_id().getCountryId() + "')");
    }

    /**
     * Method untuk melakukan Update atau Merubah data yang sudah ada
     * pada Tabel Locations
     *
     * @param location berisi data tabel yang akan di Ubah
     * @return mengembalikan data hasil update
     */
    public boolean updateLocation(Location location) {
        return this.eksekusi("update locations set street_address='" + location.getStreet_address()
                + "', POSTAL_CODE='" + location.getPostal_code()
                + "', CITY='" + location.getCity()
                + "', STATE_PROVINCE='" + location.getState_province()
                + "', COUNTRY_ID='" + location.getCountry_id().getCountryId()
                + "' where location_id=" + location.getLocation_id());
    }

    /**
     * Method untuk menghapus Data yang ada pada Tabel Locations
     * @param locationId Berisi ID dari Locations yang akan di hapus
     * @return mengembalikan data hasil Hapus
     */
    public boolean hapusLocation(int locationId) {
        return this.eksekusi("delete from locations where location_id ='" + locationId + "'");
    }

    /**
     * Fungsi yang akan di gunakan untuk mencari data Locations
     * @param category berisi kategori yang akan di cari dalam case ini merupakan Nama Kolom Tabel
     * @param cari berisi teks yang ingin di cari, atau data yang di cari sesuai kategori
     * @return mengembalikan data hasil pencarian
     */
    public List<Location> searchLocation(String category, String cari) {
        return this.getData("select * from locations where regexp_like(" + category + ",'" + cari + "','i') order by 1");
    }

    /**
     * Fungsi yang akan di gunakan untuk mencari data Nama Country pada tabel Countries
     * @param category berisi kategori yang akan di cari dalam case ini merupakan Nama Kolom Tabel
     * @param cari berisi teks yang ingin di cari, atau data yang di cari sesuai kategori
     * @return mengembalikan data hasil pencarian
     */
    public List<Location> searchByName(String category, String cari) {
        return this.getData("select * from locations l left join countries c on l.country_id = c.country_id where regexp_like(c." + category + ",'" + cari + "','i')order by 1");
    }

    /**
     * Fungsi yang akan di gunakan untuk mengambil semua data yang ada pada Tabel Locations
     * @return mengembalikan data hasil pengambilan sesuai query
     */
    public List<Location> getAllDataLocation() {
        return this.getData("select * from locations order by 1");
    }

    /**
     * Fungsi untuk mendapatkan data berdasarkan ID Locations
     * @param id Berisi ID Locations
     * @return mengembalikan data pencarian sesuai dengan ID Locations
     */
    public List<Location> getById(int id) {
        return this.getData("select * from locations where location_id = " + id);
    }

    /**
     * Fungsi untuk mengambil data City pada Locations berdasarkan LocationID
     * untuk di gunakan pada View Tabel Lain
     * @param sql berisi query yang akan di lakukan
     * @return mengembalikan data City dan LocationID
     */
    public List<Location> getIdAndCity(String sql) {
        List<Location> locations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocation_id(resultSet.getInt("LOCATION_ID"));
                location.setCity(resultSet.getString("CITY"));
                locations.add(location);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return locations;
    }

    /**
     * Fungsi query untuk mendapatkan data LocationID dan City
     * @param id disi LocationID yang di cari
     * @return mengembalikan Hasil dari pencarian ID
     */
    public List<Location> getLocationIdAndCity(int id) {
        return this.getIdAndCity("select location_id, city from locations");
    }

}
