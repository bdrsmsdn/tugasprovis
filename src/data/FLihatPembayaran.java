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
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class FLihatPembayaran extends javax.swing.JInternalFrame {

    java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    //diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private final String tanggal = smpdtfmt.format(tglsekarang);
    
    /**
     * Creates new form FLihatBarang
     */
    public FLihatPembayaran() {
        initComponents();
        tabel();
        txtTempId.setVisible(false);
        txtTempHarga.setVisible(false);
    }

    public void clearComponents() {
        txtTempId.setText("");
        txtTempHarga.setText("");
    }
    
private void tabel(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Pembayaran");
    t.addColumn("Nama Barang");
    t.addColumn("Total Bayar");
    t.addColumn("Nama Pembeli");
    t.addColumn("Tanggal Bayar");       
    t.addColumn("Keterangan");
     tabelPembayaran.setModel(t); 
 
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
            
    //state
    Statement st = conn.createStatement();
    
    //query sql
    String sql = "SELECT pe.id_pembayaran, b.nama_barang, pe.total_bayar, p.nama_pembeli, pe.tgl_bayar, t.keterangan "
            + "FROM pembayaran as pe JOIN transaksi as t JOIN barang as b JOIN pembeli as p WHERE "
            + "t.id_barang = b.id_barang AND t.id_pembeli = p.id_pembeli AND t.id_transaksi = pe.id_transaksi";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_pembayaran"),
            rs.getString("nama_barang"),
            rs.getString("total_bayar"),
            rs.getString("nama_pembeli"),
            rs.getString("tgl_bayar"),    
            rs.getString("keterangan"),    
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}

private void cariPembayaran(){ 
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("ID Pembayaran");
    t.addColumn("Nama Barang");
    t.addColumn("Total Bayar");
    t.addColumn("Nama Pembeli");
    t.addColumn("Tanggal Bayar");       
    t.addColumn("Keterangan");
     tabelPembayaran.setModel(t); 
 
 try { 
    //conect
    Connection conn = (Connection) Config.configDB();
            
    //state
    Statement st = conn.createStatement();
    
    //query sql
    String sql = "SELECT pe.id_pembayaran, b.nama_barang, pe.total_bayar, p.nama_pembeli, pe.tgl_bayar, t.keterangan "
            + "FROM pembayaran as pe JOIN transaksi as t JOIN barang as b JOIN pembeli as p WHERE "
            + "t.id_barang = b.id_barang AND t.id_pembeli = p.id_pembeli AND pe.id_transaksi = t.id_transaksi AND pe.id_pembayaran = '%"+ txtCari.getText() +"%'";

    //exce
    ResultSet rs = st.executeQuery(sql);
     while (rs.next()) { 
        t.addRow(new Object[]{ 
            rs.getString("id_pembayaran"),
            rs.getString("nama_barang"),
            rs.getString("total_bayar"),
            rs.getString("nama_pembeli"),
            rs.getString("tgl_bayar"),    
            rs.getString("keterangan"),    
        }); 
    }
     rs.close();
    st.close();
    }catch (Exception e) { 
    JOptionPane.showMessageDialog(null,"Error : "+e); 
    } 
}
    
public void confirmPembayaran(){
        try { 
            
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "insert into pembayaran(tgl_bayar, total_bayar, id_transaksi) values ('"+tanggal+"',"+txtTempHarga.getText()+","+txtTempId.getText()+")";
            String sql2 = "update transaksi set keterangan='LUNAS' where id_transaksi = "+txtTempId.getText();
            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null, "Transaksi sudah dikonfirmasi!");
            st.close();  
            tabel();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error : "+e); 
        } 
    }

public void hapusPembayaran(){
        try {             
            Connection conn = (Connection) Config.configDB();
            Statement st = conn.createStatement();
            String sql = "delete from pembayaran where id_pembayaran = " + txtTempId.getText();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            clearComponents();
            st.close();   
            tabel();
        } catch (Exception e) { 
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
        tabelPembayaran = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tblHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        tblCari = new javax.swing.JButton();
        txtTempId = new javax.swing.JTextField();
        txtTempHarga = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(168, 218, 220));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelPembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPembayaran);

        jPanel2.setBackground(new java.awt.Color(69, 123, 157));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 250, 238));
        jLabel1.setText("LIHAT PEMBAYARAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
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
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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

        tblHapus.setText("Hapus");
        tblHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblHapusActionPerformed(evt);
            }
        });

        tblCari.setText("Cari");
        tblCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTempId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblCari)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tblCari)
                    .addComponent(tblHapus)
                    .addComponent(txtTempId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblHapusActionPerformed
        // TODO add your handling code here:
        int val = JOptionPane.showConfirmDialog(null, "Kamu yakin mau menghapus data ini?", "", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        if(val == JOptionPane.YES_OPTION){
            hapusPembayaran();
        }
    }//GEN-LAST:event_tblHapusActionPerformed

    private void tblCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblCariActionPerformed
        // TODO add your handling code here:
        cariPembayaran();
    }//GEN-LAST:event_tblCariActionPerformed

    private void tabelPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembayaranMouseClicked
        // TODO add your handling code here:
        int baris = tabelPembayaran.rowAtPoint(evt.getPoint());

        String id = tabelPembayaran.getValueAt(baris, 0).toString();
        txtTempId.setText(id);
        txtTempId.setEditable(false);
        
        String hrg = tabelPembayaran.getValueAt(baris, 0).toString();
        txtTempHarga.setText(hrg);
        txtTempHarga.setEditable(false);
    }//GEN-LAST:event_tabelPembayaranMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPembayaran;
    private javax.swing.JButton tblCari;
    private javax.swing.JButton tblHapus;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtTempHarga;
    private javax.swing.JTextField txtTempId;
    // End of variables declaration//GEN-END:variables
}
