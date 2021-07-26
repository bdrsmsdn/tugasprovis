/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import db.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author HP
 */
public class FPembayaran extends javax.swing.JInternalFrame {
    
    java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    //diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private final String tanggal = smpdtfmt.format(tglsekarang);
    
    /**
     * Creates new form FTransaksi
     */
    public FPembayaran() {
        initComponents();
        tabel();
        tampilTransaksi();
    }
    
    public void tampilTransaksi() {        
        
        try {            
        //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT id_transaksi from transaksi WHERE keterangan != 'LUNAS' ORDER BY id_transaksi ASC";
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_transaksi");
                cbTransaksi.addItem((String)ob[0]);
            }
            
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    public void clearComponents() {
        txtIdb.setText("");
        txtIdp.setText("");
        txtNamab.setText("");
        txtHargab.setText("");
        txtNamap.setText("");
        cbTransaksi.removeAllItems();
    }
    
    private void tabel(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Pembayaran");
    t.addColumn("Nama Barang"); 
    t.addColumn("Total Bayar");
    t.addColumn("Nama Pembeli");
    t.addColumn("Tanggal");        
    t.addColumn("Keterangan");
    tabelPembayaran.setModel(t); 
 
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
    
    //query sql
    String sql = "SELECT pe.id_pembayaran, t.tanggal, t.keterangan,"
            + " p.nama_pembeli,b.nama_barang, b.harga FROM pembayaran as pe JOIN transaksi as t"
            + " JOIN barang as b JOIN pembeli as p WHERE pe.id_transaksi = t.id_transaksi AND t.id_barang = b.id_barang "
            + "AND t.id_pembeli = p.id_pembeli ORDER BY pe.id_pembayaran ASC";

    Statement st = conn.createStatement();
    
    //exce
    ResultSet rs = st.executeQuery(sql);
    rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_pembayaran"),
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
    
    public void tampilData(){
        try{
            //connect ke db
            Connection conn = (Connection) Config.configDB();
            
            //buka query
            Statement st = conn.createStatement();
            
            //query sql
            String sql = "SELECT t.id_transaksi, t.id_barang, t.id_pembeli, t.tanggal, t.keterangan, p.nama_pembeli,"
            + "b.nama_barang, b.harga FROM transaksi as t JOIN barang as b JOIN pembeli as p WHERE "
            + "t.id_barang = b.id_barang AND t.id_pembeli = p.id_pembeli AND t.id_transaksi = "+cbTransaksi.getSelectedItem();
            
            //exce
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Object[] ob = new Object[5];
                ob[0] = rs.getString("id_barang");
                ob[1] = rs.getString("nama_barang");
                ob[2] = rs.getString("harga");
                ob[3] = rs.getString("id_pembeli");
                ob[4] = rs.getString("nama_pembeli");
                
                //set data ke text field
                txtIdb.setText((String) ob[0]);
                txtNamab.setText((String) ob[1]);
                txtHargab.setText((String) ob[2]);
                txtIdp.setText((String) ob[3]);
                txtNamap.setText((String) ob[4]);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPembayaran = new javax.swing.JTable();
        tblConfirm = new javax.swing.JButton();
        txtIdb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHargab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamab = new javax.swing.JTextField();
        txtIdp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNamap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbTransaksi = new javax.swing.JComboBox();
        tblRefresh = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PEMBAYARAN");

        tabelPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelPembayaran);

        tblConfirm.setText("Konfirmasi");
        tblConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblConfirmActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Barang");

        jLabel4.setText("Harga");

        jLabel5.setText("ID Pembeli");

        jLabel6.setText("Nama Barang");

        jLabel7.setText("Nama Pembeli");

        jLabel8.setText("ID Transaksi");

        cbTransaksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih ID" }));
        cbTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTransaksiActionPerformed(evt);
            }
        });

        tblRefresh.setText("Refresh");
        tblRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdp)
                                .addGap(57, 57, 57))
                            .addComponent(txtNamab)
                            .addComponent(txtHargab)
                            .addComponent(txtNamap, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(tblConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tblRefresh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNamab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHargab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNamap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtIdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tblConfirm)
                    .addComponent(tblRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblConfirmActionPerformed
        // TODO add your handling code here:
        
        try { 
            
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "insert into pembayaran(tgl_bayar, total_bayar, id_transaksi) values ('"+tanggal+"',"+txtHargab.getText()+","+cbTransaksi.getSelectedItem()+")";
            String sql2 = "update transaksi set keterangan='LUNAS' where id_transaksi = "+cbTransaksi.getSelectedItem();
            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            clearComponents();
            st.close();                              
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        } 
    }//GEN-LAST:event_tblConfirmActionPerformed

    private void cbTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTransaksiActionPerformed
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_cbTransaksiActionPerformed

    private void tblRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblRefreshActionPerformed
        // TODO add your handling code here:
        clearComponents();
        tabel();
        tampilTransaksi();
    }//GEN-LAST:event_tblRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPembayaran;
    private javax.swing.JButton tblConfirm;
    private javax.swing.JButton tblRefresh;
    private javax.swing.JTextField txtHargab;
    private javax.swing.JTextField txtIdb;
    private javax.swing.JTextField txtIdp;
    private javax.swing.JTextField txtNamab;
    private javax.swing.JTextField txtNamap;
    // End of variables declaration//GEN-END:variables
}
