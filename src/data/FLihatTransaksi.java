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
public class FLihatTransaksi extends javax.swing.JInternalFrame {

    /**
     * Creates new form FLihatBarang
     */
    public FLihatTransaksi() {
        initComponents();
        tabel();
        tampilBarang();
        tampilPembeli();
        cbBarang.setSelectedIndex(0);
        cbPembeli.setSelectedIndex(0);
    }

    public void clearComponents() {
        txtId.setText("");
        txtTanggal.setText("");
        txtHarga.setText("");
    }
    
private void tabel(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Transaksi");
    t.addColumn("Nama Barang");   
    t.addColumn("Tanggal");
    t.addColumn("Harga");
    t.addColumn("Nama Pembeli");
    t.addColumn("Keterangan");
     tabelTransaksi.setModel(t); 
 
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
            
    //state
    Statement st = conn.createStatement();
    
    //query sql
    String sql = "SELECT t.id_transaksi, b.nama_barang, b.harga, p.nama_pembeli, t.tanggal, t.keterangan "
            + "FROM transaksi as t JOIN barang as b JOIN pembeli as p WHERE "
            + "t.id_barang = b.id_barang AND t.id_pembeli = p.id_pembeli";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_transaksi"),
            rs.getString("nama_barang"), 
            rs.getString("harga"), 
            rs.getString("nama_pembeli"),
            rs.getString("tanggal"),                            
            rs.getString("keterangan"),
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}

private void cariTransaksi(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Transaksi");
    t.addColumn("Nama Barang");   
    t.addColumn("Tanggal");
    t.addColumn("Harga");
    t.addColumn("Nama Pembeli");
    t.addColumn("Keterangan");
     tabelTransaksi.setModel(t); 
 
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
    String sql = "SELECT t.id_transaksi, b.nama_barang, b.harga, p.nama_pembeli, t.tanggal, t.keterangan "
            + "FROM transaksi as t JOIN barang as b JOIN pembeli as p WHERE "
            + "t.id_barang = b.id_barang AND t.id_pembeli = p.id_pembeli AND (b.nama_barang like '%"+ txtCari.getText() +"%' OR p.nama_pembeli like '%"+ txtCari.getText() +"%')";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_transaksi"),
            rs.getString("nama_barang"), 
            rs.getString("harga"), 
            rs.getString("nama_pembeli"),
            rs.getString("tanggal"),                            
            rs.getString("keterangan"),
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}
    
public void editTransaksi(){
        try {            
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "update transaksi set id_barang = '" + cbBarang.getSelectedIndex() + "', id_pembeli = '" + cbPembeli.getSelectedIndex() + "'"
                    + "where id_transaksi = '" + txtId.getText() + "'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
            clearComponents();
            st.close();                              
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        }
    }
    
    public void hapusTransaksi(){
        try {             
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "delete from transaksi where id_transaksi = " + txtId.getText();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            clearComponents();
            st.close();                              
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        }
    }

    public void tampilBarang() {        
        
        try {            
        //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT nama_barang from barang ORDER BY id_barang ASC";
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("nama_barang");
                cbBarang.addItem((String)ob[0]);
            }
            
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    public void tampilPembeli() {        
        
        try {            
        //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT nama_pembeli from pembeli ORDER BY id_pembeli ASC";
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("nama_pembeli");
                cbPembeli.addItem((String)ob[0]);
            }
            
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    public void tampilData(){
        try{
            //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT harga from barang where nama_barang = '"+cbBarang.getSelectedItem()+"'";
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                txtHarga.setText(rs.getString("harga"));
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
        tabelTransaksi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtCari = new javax.swing.JTextField();
        tblCari = new javax.swing.JButton();
        tblEdit = new javax.swing.JButton();
        tblHapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        cbBarang = new javax.swing.JComboBox();
        cbPembeli = new javax.swing.JComboBox();

        jPanel1.setBackground(new java.awt.Color(168, 218, 220));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelTransaksi);

        jPanel2.setBackground(new java.awt.Color(69, 123, 157));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 250, 238));
        jLabel1.setText("LIHAT TRANSAKSI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
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
                .addGap(261, 261, 261)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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

        tblCari.setText("Cari");
        tblCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblCariActionPerformed(evt);
            }
        });

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

        jLabel2.setText("ID Transaksi");

        jLabel3.setText("Nama Barang");

        jLabel6.setText("Harga");

        jLabel4.setText("Nama Pembeli");

        jLabel5.setText("Tanggal");

        jLabel7.setText("Keterangan");

        cbBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Barang" }));
        cbBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarangActionPerformed(evt);
            }
        });

        cbPembeli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Nama Pembeli" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cbPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tblCari))
                        .addGap(135, 135, 135)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tblEdit)
                        .addComponent(tblHapus)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblCariActionPerformed
        // TODO add your handling code here:
        cariTransaksi();
    }//GEN-LAST:event_tblCariActionPerformed

    private void tblEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblEditActionPerformed
        // TODO add your handling code here:
        if(txtId.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "ID Transaksi tidak boleh kosong!");
        } else if (!txtId.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "ID Transaksi hanya berupa angka!");
        } else if(cbBarang.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Nama Barang tidak boleh kosong!");
        } else if(cbPembeli.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Nama Pembeli tidak boleh kosong!");
        } else if (txtHarga.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga Barang tidak boleh kosong!");
        } else if (!txtHarga.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Harga Barang hanya berupa angka!");
        } else {
            editTransaksi();
        }
    }//GEN-LAST:event_tblEditActionPerformed

    private void tblHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblHapusActionPerformed
        // TODO add your handling code here:
        int val = JOptionPane.showConfirmDialog(null, "Kamu yakin mau menghapus data ini?", "", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        if(val == JOptionPane.YES_OPTION){
            hapusTransaksi();
        }
    }//GEN-LAST:event_tblHapusActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        int baris = tabelTransaksi.rowAtPoint(evt.getPoint());

        String id = tabelTransaksi.getValueAt(baris, 0).toString();
        txtId.setText(id);
        txtId.setEditable(false);
        
        String nama = tabelTransaksi.getValueAt(baris, 1).toString();
        cbBarang.setSelectedItem(nama);        
        
        String harga = tabelTransaksi.getValueAt(baris, 2).toString();
        txtHarga.setText(harga);
        txtHarga.setEditable(false);
        
        String namab = tabelTransaksi.getValueAt(baris, 3).toString();
        cbPembeli.setSelectedItem(namab);  
        
        String tgl = tabelTransaksi.getValueAt(baris, 4).toString();
        txtTanggal.setText(tgl);
        
        String ket = tabelTransaksi.getValueAt(baris, 5).toString();
        txtKeterangan.setText(ket);
        txtKeterangan.setEditable(false);
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void cbBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarangActionPerformed
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_cbBarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbBarang;
    private javax.swing.JComboBox cbPembeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JButton tblCari;
    private javax.swing.JButton tblEdit;
    private javax.swing.JButton tblHapus;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
