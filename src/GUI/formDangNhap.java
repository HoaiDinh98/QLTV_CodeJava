/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DangNhapDAO;
import POJO.DangNhap;
import javax.swing.JOptionPane;

/**
 *
 * @author 84328
 */
public class formDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DN
     */
    public formDangNhap() {
        this.setTitle("Đăng nhập Phần mềm Quản lý Thư viện");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        btnDN = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        AnhNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hopstarter-Soft-Scraps-User-Administrator-Blue.16.png"))); // NOI18N
        jLabel2.setText("Tài khoản:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Papirus-Team-Papirus-Apps-Preferences-desktop-user-password.16.png"))); // NOI18N
        jLabel3.setText("Mật khẩu:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        txtTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 240, 30));

        txtMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKActionPerformed(evt);
            }
        });
        getContentPane().add(txtMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 240, 30));

        btnDN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDN.setText("Đăng nhập");
        btnDN.setBorder(null);
        btnDN.setContentAreaFilled(false);
        btnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDNActionPerformed(evt);
            }
        });
        getContentPane().add(btnDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 200, 60));

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setBorder(null);
        btnExit.setContentAreaFilled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 190, 60));

        AnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hinhnen3.png"))); // NOI18N
        AnhNen.setMinimumSize(new java.awt.Dimension(1800, 1080));
        getContentPane().add(AnhNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 760, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMKActionPerformed

    private void btnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDNActionPerformed
        String tenDN = txtTK.getText();
        String matKhau = txtMK.getText();
        DangNhap dn = new DangNhap();
        dn.setTenDN(tenDN);
        dn.setMatKhau(matKhau);

        boolean KiemTraDangNhap = false;
        KiemTraDangNhap = DangNhapDAO.KiemTraDangNhap(dn);
        if(KiemTraDangNhap) {
            JOptionPane.showMessageDialog(this, "Đăng nhập Thành công !!!");
            this.setVisible(false);
            formTrangChu trangChu = new formTrangChu(tenDN);
            if (!DangNhapDAO.KiemTraQuyenDangNhap(dn))
            trangChu.EnablebtnQLNV();
            trangChu.setLocationRelativeTo(null);
            trangChu.setVisible(true);
        } else JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
    }//GEN-LAST:event_btnDNActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int exit = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình ?", "Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
        if (exit == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhNen;
    private javax.swing.JButton btnDN;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}
