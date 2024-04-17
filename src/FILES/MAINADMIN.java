/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class MAINADMIN extends javax.swing.JFrame {
    
    /**
     * Creates new form MAINADMIN
     */
    
    
    public static int kye;
    public MAINADMIN() {
        initComponents();
       
    }

    public int getKye() {
        return kye;
    }

    public void setKye(int kye) {
        this.kye = kye;
    }
    
    
    
    
    
    
    public static void  showmasseg (){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"A Form is Already open");
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-admin-100.png"))); // NOI18N
        jLabel2.setText("ADMIN MAIN PANAL");
        jLabel2.setIconTextGap(10);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 620, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/exm.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 490));

        jMenuBar2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ACTIONS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 48), new java.awt.Color(255, 51, 51))); // NOI18N
        jMenuBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-category-100.png"))); // NOI18N
        jMenu4.setText("ADD CATAGORY");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu4MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu4MouseReleased(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu4);

        jMenu5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-add-100.png"))); // NOI18N
        jMenu5.setText(" ADD QUESTION");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu5);

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-edit-100.png"))); // NOI18N
        jMenu1.setText(" MANAGE QUESTION");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-exam-100 (1).png"))); // NOI18N
        jMenu2.setText(" RESULTS");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu2);

        jMenu8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-students-100.png"))); // NOI18N
        jMenu8.setText(" REGISTER STUDENT");
        jMenu8.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });

        jMenuItem2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-child-100.png"))); // NOI18N
        jMenuItem2.setText("REGISTER NEW");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);
        jMenu8.add(jSeparator1);

        jMenuItem3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-students-100.png"))); // NOI18N
        jMenuItem3.setText("REGISTERED");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuBar2.add(jMenu8);

        jMenu6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-setting-100.png"))); // NOI18N
        jMenu6.setText(" SETTING ");
        jMenu6.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu6);

        jMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-logout-100.png"))); // NOI18N
        jMenu3.setText("  LOGOUT ");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        jMenu7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-100.png"))); // NOI18N
        jMenu7.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu7KeyPressed(evt);
            }
        });
        jMenuBar2.add(jMenu7);

        setJMenuBar(jMenuBar2);
        jMenuBar2.getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1212, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
         if(kye==0){
            this.dispose();
            login l = new login();
            l.setVisible(true);
        }else{
            showmasseg(); 
        }
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        if(kye==0){
            new ADDQUESTION().setVisible(true);
            kye=1;
            
        }else{
            showmasseg();
                 
        }
            
            
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
         if(kye==0){
            new MANAGEQUESTION().setVisible(true);
            kye=1;
            
        }else{
           showmasseg();
                 
        }
            
           
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseReleased

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        
        if(kye==0){
            CATEGORY1 c =new CATEGORY1();
            c.setVisible(true);
            kye=1;
            
        }else{
           showmasseg();
                 
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu7KeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu7KeyPressed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        if(kye==0){
            System.exit(0);
            
        }else{
            showmasseg();
                 
        }
        
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(kye==0){
            new ALLRESULTS().setVisible(true);
            
            kye=1;
            
        }else{
            showmasseg();
                 
        }
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        if(kye==0){
            new SETTING().setVisible(true);
            
            kye=1;
            
        }else{
            showmasseg();
                 
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(kye==0){
            new allstudents().setVisible(true);
            
            kye=1;
            
        }else{
            showmasseg();
                 
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        if(kye==0){
//            new REGISTER().setVisible(true);
            REGISTER R = new REGISTER(1);
            R.setVisible(true);
            kye=1;
            
        }else{
            showmasseg();
                 
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        // TODO add your handling code here:
        jMenu4.setFocusPainted(true);
    }//GEN-LAST:event_jMenu4MouseEntered

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
            java.util.logging.Logger.getLogger(MAINADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAINADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAINADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAINADMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MAINADMIN m =new MAINADMIN();
                m.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
