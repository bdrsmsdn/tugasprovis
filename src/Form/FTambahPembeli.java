/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import db.Config;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author HP
 */
public class FTambahPembeli extends javax.swing.JInternalFrame {

    /**
     * Creates new form FTambahPembeli
     */
    public FTambahPembeli() {
        initComponents();
    }
    
    public void clearComponents() {
        txtNamap.setText("");
        txtNop.setText("");
        txtAlamatp.setText("");
    }

    public void tambahBarang() {
        try {
            String jkk = "";
            if(btnL.isSelected()){
                jkk = "Laki-laki";
            } else if (btnP.isSelected()){
                jkk = "Perempuan";
            }
            //conect
            Connection conn = (Connection) Config.configDB();
            
            //state
            Statement state = conn.createStatement();
            
            //query
            String sql = "INSERT INTO pembeli(nama_pembeli, jk, no_telp, alamat) VALUES('"+ txtNamap.getText() +"' , '"+ jkk +"', '" + txtNop.getText() + ""
                    + "', '"+ txtAlamatp.getText() +"')";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            clearComponents();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
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

        jProgressBar1 = new javax.swing.JProgressBar();
        btnGroupJk = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNamap = new javax.swing.JTextField();
        txtNop = new javax.swing.JTextField();
        tblResetp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tblSubmitp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAlamatp = new javax.swing.JTextField();
        btnL = new javax.swing.JRadioButton();
        btnP = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TAMBAH PEMBELI");

        jLabel5.setText("No. Telepon");

        jLabel6.setText("Alamat");

        tblResetp.setText("Reset");
        tblResetp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblResetpActionPerformed(evt);
            }
        });

        jLabel4.setText("Jenis Kelamin");

        tblSubmitp.setText("Submit");
        tblSubmitp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblSubmitpActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Pembeli");

        btnGroupJk.add(btnL);
        btnL.setText("Laki-laki");

        btnGroupJk.add(btnP);
        btnP.setText("Perempuan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNamap, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtAlamatp, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtNop))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnP))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(tblResetp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblSubmitp)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNamap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnL)
                        .addComponent(btnP)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtAlamatp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblResetp)
                    .addComponent(tblSubmitp))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResetpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblResetpActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_tblResetpActionPerformed

    private void tblSubmitpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblSubmitpActionPerformed
        // TODO add your handling code here:
        if (txtNamap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Pembeli tidak boleh kosong!");
        } else if (txtNop.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Telepon tidak boleh kosong!");
        } else if (!txtNop.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "No Telepon hanya berupa angka!");
        } else if (txtAlamatp.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pilih salah satu Supplier!");
        } else {
            tambahBarang();
        }
    }//GEN-LAST:event_tblSubmitpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupJk;
    private javax.swing.JRadioButton btnL;
    private javax.swing.JRadioButton btnP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton tblResetp;
    private javax.swing.JButton tblSubmitp;
    private javax.swing.JTextField txtAlamatp;
    private javax.swing.JTextField txtNamap;
    private javax.swing.JTextField txtNop;
    // End of variables declaration//GEN-END:variables
}
