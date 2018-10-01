/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DepartmentController;
import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.LocationDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Employee;
import tools.Koneksi;

/**
 *
 * @author Martin
 */
public class DepartmentView extends javax.swing.JInternalFrame {
    
    private final SerbaGunaView serbaGuna;

    private final DepartmentController controller;
    
    private final LocationDAO ldao;
    private final EmployeeDAO edao;
    private final DepartmentDAO ddao;
    private String[] cmbItem = {"department_id", "department_name", "manager_id", "location_id"};
    
    /**
     * Creates new form DepartmentView
     */
    public DepartmentView() {
        initComponents();
        controller = new DepartmentController(new Koneksi().getKoneksi());
        serbaGuna = new SerbaGunaView();
        ldao = new LocationDAO(new Koneksi().getKoneksi());
        edao = new EmployeeDAO(new Koneksi().getKoneksi());
        ddao = new DepartmentDAO(new Koneksi().getKoneksi());
        controller.loadCmbDepartmentName(cmbDepartmentName);
        controller.loadCmbManagerId(cmbManagerId);
        controller.loadCmbLocationId(cmbLocationId);
        bindingDepartment(controller.viewDepartment());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        cmbKategori = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDepartmentId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        cmbDepartmentName = new javax.swing.JComboBox<>();
        cmbManagerId = new javax.swing.JComboBox<>();
        cmbLocationId = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartment);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department ID", "Department Name", "Manager ID", "Location ID" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        jLabel5.setText("Search :");

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Department ID :");

        txtDepartmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Department Name :");

        jLabel3.setText("Manager ID :");

        jLabel4.setText("Location ID :");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbDepartmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartmentNameActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbManagerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(377, 377, 377))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbManagerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentIdActionPerformed

    /**
     * Menjalankan JOptionPane dan mengluarkan pesan saat tombol delete ditekan
     * @param evt jenis event
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    int messageBox = JOptionPane.showConfirmDialog(this, "Are You Sure ?", "Delete", JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
        if(messageBox == JOptionPane.YES_OPTION){
            String pesan = controller.hapusDepartment(txtDepartmentId.getText());
        serbaGuna.tampilPesan(this, pesan, "Pesan Delete");
        bindingDepartment(controller.viewDepartment());
        reset();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Mengambil isi data pada tabel saat di klik oleh mouse
     * @param evt jenis event
     */
    private void tblDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentMouseClicked
        // TODO add your handling code here:
        int row = tblDepartment.getSelectedRow();
        txtDepartmentId.setText(tblDepartment.getValueAt(row, 1).toString());
        cmbDepartmentName.setSelectedItem(tblDepartment.getValueAt(row, 2).toString());
        if(tblDepartment.getValueAt(row, 3) == null) cmbManagerId.setSelectedItem(null);
        else cmbManagerId.setSelectedItem(tblDepartment.getValueAt(row, 3).toString());
        cmbLocationId.setSelectedItem(tblDepartment.getValueAt(row, 4).toString());
        edit();
    }//GEN-LAST:event_tblDepartmentMouseClicked

    /**
     * Melakukan pencarian dari input/text yang dimasukan oleh user menggunakan tombol enter
     * @param evt jenis event
     */
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!txtSearch.getText().equalsIgnoreCase("")){
                bindingDepartment(controller.searchDepartment(cmbItem[cmbKategori.getSelectedIndex()], txtSearch.getText()));
            }
//            if(cmbKategori.getSelectedItem().toString().equals("Department ID")){
//                bindingDepartment(controller.searchDepartment("department_id",txtSearch.getText()));
//            }
//            if(cmbKategori.getSelectedItem().toString().equals("Department Name")){
//                bindingDepartment(controller.searchDepartment("department_name",txtSearch.getText()));
//            }
//            if(cmbKategori.getSelectedItem().toString().equals("Manager ID")){
//                bindingDepartment(controller.searchDepartment("manager_id",txtSearch.getText()));
//            }
//            if(cmbKategori.getSelectedItem().toString().equals("Location ID")){
//                bindingDepartment(controller.searchDepartment("location_id",txtSearch.getText()));
//            }
        }
        if (txtSearch.getText().equals("")) {
            bindingDepartment(controller.viewDepartment());
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

    /**
     * Melakukan simpan atau update saat tombol save di tekan
     * @param evt jenis event
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(!txtDepartmentId.isEnabled()){
            String pesanUpdate = controller.simpanUpdateDepartment(txtDepartmentId.getText(), cmbDepartmentName.getSelectedItem().toString(),
                cmbManagerId.getSelectedItem().toString(), cmbLocationId.getSelectedItem().toString(), false);
        serbaGuna.tampilPesan(this, pesanUpdate, "Pesan Update");
        bindingDepartment(controller.viewDepartment());
        reset();
        }
        else{
            String pesanSimpan = controller.simpanUpdateDepartment(txtDepartmentId.getText(), cmbDepartmentName.getSelectedItem().toString(),
                cmbManagerId.getSelectedItem().toString(), cmbLocationId.getSelectedItem().toString(), true);
        serbaGuna.tampilPesan(this, pesanSimpan, "Pesan Simpan");
        bindingDepartment(controller.viewDepartment());
        reset();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbDepartmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartmentNameActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartmentNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbDepartmentName;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbLocationId;
    private javax.swing.JComboBox<String> cmbManagerId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTextField txtDepartmentId;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Menampilkan data department dalam tabel department
     * @param department list department
     */
    private void bindingDepartment(List<Department> department) {
        String[] header = {"No", "Department ID", "Department Name", "Manager Name", "City"};
        String[][] data = new String[department.size()][header.length];
        for (int i = 0; i < department.size(); i++) {
            Employee employee = department.get(i).getEmployee();
            data[i][0] = (i + 1) + "";
            data[i][1] = department.get(i).getDepartmentId() + "";
            data[i][2] = department.get(i).getDepartmentName() + "";
            if(employee!=null) data[i][3] = department.get(i).getEmployee().getEmployeeId() + " - " + department.get(i).getEmployee().getLastName()+ "";
            data[i][4] = department.get(i).getLocation().getLocation_id()+ " - " + department.get(i).getLocation().getCity() + "";
        }
        tblDepartment.setModel(new DefaultTableModel(data, header));
        reset();
    }

    /**
     * Menyalakan tombol delete dan mematikan textfield Department Id
     */
    private void edit() {
        txtDepartmentId.setEnabled(false);
        btnDelete.setEnabled(true);
    }

    /**
     * Mengeset textfield department Id dengan method autoId, menyalakan textfield dan menghilangkan kemampuan edit dari
     * Department Id, mematikan tombol delete, mengembalikan seluruh combobox ke pilihan pertama
     */
    private void reset() {
        txtDepartmentId.setText(ddao.autoId()+"");
        txtDepartmentId.setEnabled(true);
        btnDelete.setEnabled(false);
        txtDepartmentId.setEditable(false);
        cmbDepartmentName.setSelectedIndex(0);
        cmbManagerId.setSelectedIndex(0);
        cmbLocationId.setSelectedIndex(0);
    }
    
}
