/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import db.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FLihatBarang extends javax.swing.JInternalFrame {

    /**
     * Creates new form FLihatBarang
     */
    public FLihatBarang() {
        initComponents();
        tabel();
        tampilSupplier();
    }

    public void clearComponents() {
        txtId.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtStok.setText("");
        cbSupplier.setSelectedIndex(0);
    }
    
private void tabel(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Barang");
    t.addColumn("Nama Barang");   
    t.addColumn("Harga");
    t.addColumn("Stok");
    t.addColumn("Nama Supplier");
     tabelBarang.setModel(t); 
 
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
            
    //state
    Statement st = conn.createStatement();
    
    //query sql
    String sql = "SELECT b.id_barang, b.nama_barang, b.harga, b.stok, s.nama_supplier FROM barang AS b"
            + " JOIN supplier AS s WHERE b.id_supplier = s.id_supplier ORDER BY nama_barang ASC";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_barang"),
            rs.getString("nama_barang"),   
            rs.getString("harga"), 
            rs.getString("stok"), 
            rs.getString("nama_supplier")
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}

private void cariBarang(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Barang");
    t.addColumn("Nama Barang");   
    t.addColumn("Harga");
    t.addColumn("Stok");
    t.addColumn("Nama Supplier");
     tabelBarang.setModel(t); 
 
     int lengthRow = t.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            t.removeRow(n);
        }
     
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
            
    //state
    Statement st = conn.createStatement();
    
    //query sql
    String sql = "SELECT b.id_barang, b.nama_barang, b.harga, b.stok, s.nama_supplier FROM barang AS b"
            + " JOIN supplier AS s WHERE b.id_supplier = s.id_supplier AND nama_barang like '%"+ txtCari.getText() +"%'";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_barang"),
            rs.getString("nama_barang"),   
            rs.getString("harga"), 
            rs.getString("stok"), 
            rs.getString("nama_supplier")
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}
    
public void editBarang(){
        try {            
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "update barang set nama_barang = '"+ txtNama.getText() +"',"
                    + "harga = '"+ txtHarga.getText() +"', stok = '"+ txtStok.getText() +"',"
                    + " id_supplier = "+ cbSupplier.getSelectedIndex() +" where id_barang = "+ txtId.getText();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
            clearComponents();
            st.close();     
            tabel();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        } 
    }
    
    public void hapusBarang(){
        try {             
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "delete from barang where id_barang = " + txtId.getText();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            clearComponents();
            st.close();       
            tabel();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        } 
    }

    public void tampilSupplier() {        
        
        try {            
        //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT nama_supplier from supplier ORDER BY id_supplier ASC";
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("nama_supplier");
                cbSupplier.addItem((String)ob[0]);
            }
            
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        tblEdit = new javax.swing.JButton();
        tblHapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        tblCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbSupplier = new javax.swing.JComboBox();

        jPanel1.setBackground(new java.awt.Color(168, 218, 220));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jPanel2.setBackground(new java.awt.Color(69, 123, 157));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 250, 238));
        jLabel1.setText("LIHAT BARANG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(230, 57, 70));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        tblEdit.setText("Edit");
        tblEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblEditActionPerformed(evt);
            }
        });

        tblHapus.setText("Hapus");
        tblHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblHapusActionPerformed(evt);
            }
        });

        jLabel5.setText("Stok");

        jLabel2.setText("ID Barang");

        jLabel4.setText("Harga");

        jLabel3.setText("Nama Barang");

        tblCari.setText("Cari");
        tblCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblCariActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Supplier");

        cbSupplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Supplier" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tblCari))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(tblEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tblHapus)))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tblCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tblEdit)
                            .addComponent(tblHapus))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblCariActionPerformed
        // TODO add your handling code here:
        cariBarang();
    }//GEN-LAST:event_tblCariActionPerformed

    private void tblHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblHapusActionPerformed
        // TODO add your handling code here:
        int val = JOptionPane.showConfirmDialog(null, "Kamu yakin mau menghapus data ini?", "", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        if(val == JOptionPane.YES_OPTION){
            hapusBarang();
        }
    }//GEN-LAST:event_tblHapusActionPerformed

    private void tblEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblEditActionPerformed
        // TODO add your handling code here:
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong!");
        } else if (txtHarga.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong!");
        } else if (!txtHarga.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Harga hanya berupa angka!");
        } else if (txtStok.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok tidak boleh kosong!");
        } else if (!txtStok.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Stok hanya berupa angka!");
        } else if (cbSupplier.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Pilih salah satu supplier!");
        } else {
            editBarang();
        }
    }//GEN-LAST:event_tblEditActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        int baris = tabelBarang.rowAtPoint(evt.getPoint());

        String id = tabelBarang.getValueAt(baris, 0).toString();
        txtId.setText(id);
        txtId.setEditable(false);
        
        String nama = tabelBarang.getValueAt(baris, 1).toString();
        txtNama.setText(nama);
        
        String harga = tabelBarang.getValueAt(baris, 2).toString();
        txtHarga.setText(harga);
        
        String stok = tabelBarang.getValueAt(baris, 3).toString();
        txtStok.setText(stok);
        
        String supplier = tabelBarang.getValueAt(baris, 4).toString();
        cbSupplier.setSelectedItem(supplier);
    }//GEN-LAST:event_tabelBarangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JButton tblCari;
    private javax.swing.JButton tblEdit;
    private javax.swing.JButton tblHapus;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
