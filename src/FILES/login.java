package FILES;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User1
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
     public static String currentDirectory =System.getProperty("user.dir") ;
       
      Color litgreen=new java.awt.Color(102,255,0);  
//    File currentDirectory= new File("");
//    String absolutePath = currentDirectory.getAbsolutePath();
    Connection con ;
    PreparedStatement insert;
    ResultSet rs;
    int attempts=0;
    public login() {
        initComponents();
        ConnectDB c = new ConnectDB();
        con = c.Connect();
        jButton3.hide();
        jButton4.hide();
    }
    
    
    
    
    
    
    
    
    public void ADMINLOG(){
        try {       
                   if (name.getText().equals("")|| pass.getText().equals("")){
                       message.setText("EMPTY FIELD DETECTED");
                   }else{
                        String emal=name.getText();
                        String Password=pass.getText();
                        insert=con.prepareStatement("SELECT * FROM `admindetail` WHERE username=? AND password=?");
                        insert.setString(1,emal);
                        insert.setString(2,Password);
                        rs=insert.executeQuery();
                        if (rs.next()){
                            String g_Pass=rs.getString("password");
                            if (g_Pass.equals(Password)){
                                message.setText("");
                                JOptionPane.showMessageDialog(this, "LOGIN SUCCESFULL");
                                MAINADMIN m =new MAINADMIN();
                                m.setVisible(true);
                                dispose();
                            }else{
                                if (attempts<5){
                                    attempts+=1;
                                }else{
                                    jButton4.show();
                                }
                                message.setText("INCORRECT INFO");
                            }
                        }else{
                            if (attempts<5){
                                attempts+=1;
                            }else{
                                jButton4.show();
                            }
                            message.setText("INCORRECT INFO");
                            
                        }
                   }

            }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e);
                }
    }
    
    
    
    
    
    
    
    
    
    public void STUDENTLOG(){
         try{
                    if (name.getText().equals("")&& pass.getText().equals("")){
                        message.setText("EMPTY FIELD DETECTED");
                        
                }else
                {

                    String emal=name.getText();
                    String Password=pass.getText();

                        insert=con.prepareStatement("SELECT * FROM `studentdetail` WHERE username=? AND password=?");
                        insert.setString(1,emal);
                        insert.setString(2,Password);
                        rs=insert.executeQuery();
                        
                        if (rs.next()){
                            String g_Pass=rs.getString("password");
                            if (g_Pass.equals(Password)){
                                message.setText("");
                                JOptionPane.showMessageDialog(this, "LOGIN SUCCESFULL");
                                studentmain s = new studentmain(name.getText(),pass.getText());
                                s.setVisible(true);
                                this.dispose();
                            }else{
                                 message.setText("INCORRECT INFO");
                            }

                        }else{
                             message.setText("INCORRECT INFO");
                        }
                }
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e);
                }
    }
    
    
    
    
    
     public void Login(){
        
        if (select.getSelectedItem().equals("ADMIN")){
            ADMINLOG();
        }else if(select.getSelectedItem().equals("STUDENT")){ 
            STUDENTLOG();
        }else 
        {
                message.setText("Please Select a User");
        }
        
    }
    
    
    public void forgetpass(){
        try{      
                String USER=JOptionPane.showInputDialog("ENTER USERNAME");
                String CODE=JOptionPane.showInputDialog("ENTER ADMIN CODE");
                if (USER==null || CODE==null){
                    JOptionPane.showMessageDialog(this ,"REQUEST CANCELLED");
                }else{
                   
                    insert=con.prepareStatement ("SELECT * FROM `admindetail` WHERE USERNAME=? AND CODE=?");
                    insert.setString(1,USER);
                    insert.setString(2,CODE);

                    rs=insert.executeQuery();
                                if (rs.next()){
                                    String newpass=JOptionPane.showInputDialog("ENTER NEW Password");
                                    if (newpass==null || newpass.equals(""))
                                    {
                                         JOptionPane.showMessageDialog(this ,"EMPTY FIELD\nERROR");
                                    }else{
                                        insert=con.prepareStatement ("UPDATE `admindetail` SET `PASSWORD`='"+newpass+"' WHERE name='ADMIN'");
                                        insert.execute();
                                        JOptionPane.showMessageDialog(this ,"PASSWORD:-> "+newpass+"\nPASSWORD SAVED");
                                        jButton4.hide();
                                        attempts=0;
                                       
                                    }
                                    
                                }else
                                {
                                    JOptionPane.showMessageDialog(this , "INCORRECT INFO");
                                }
                }

            }catch(Exception e){
                    System.out.println(e);
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

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();
        select = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        showing = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        showing1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/quiz.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 420, 330));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        jLabel2.setText("QUIZ SYSTEM");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 270, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "USER NAME ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 18))); // NOI18N
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 250, 80));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 170, 50));

        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setText("FORGET PASSWORD");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 170, 20));

        message.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        message.setForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 20));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("REGISTER HERE");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 170, 40));

        pass.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "PASSWORD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 18))); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 250, 80));

        select.setBackground(new java.awt.Color(0, 0, 0,0));
        select.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "ADMIN", "STUDENT" }));
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 160, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/My project_1.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 220));

        showing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-child-100.png"))); // NOI18N
        jPanel4.add(showing, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 150, 140));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/My project_1.png"))); // NOI18N
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 220));

        showing1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showing1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-admin-100_1.png"))); // NOI18N
        jPanel5.add(showing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 150, 140));

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/My project_1.png"))); // NOI18N
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 220));

        jTabbedPane1.addTab("tab3", jPanel7);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 280, 260));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, 220));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-show-password-36.png"))); // NOI18N
        jToggleButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 60, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 360, 590));

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton5.setText("EXIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        
        jButton1.setBackground(Color.GREEN);
        
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
         jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new REGISTER(0).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        
        if(select.getSelectedItem().equals("STUDENT")){
             jButton3.show();
             jTabbedPane1.setSelectedIndex(0);
        }else if(select.getSelectedItem().equals("ADMIN")){
            jButton3.hide();
            jTabbedPane1.setSelectedIndex(1);
        }else
        {   
            jButton3.hide();
            jTabbedPane1.setSelectedIndex(2);
        }
        if (!select.getSelectedItem().equals("ADMIN")){
            jButton4.hide();
            
        }
      
       
    }//GEN-LAST:event_selectActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
        forgetpass();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            pass.requestFocus();
        }
    }//GEN-LAST:event_nameKeyReleased

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Enter was pressed. Your code goes here.
            Login();
        }
    }//GEN-LAST:event_passKeyReleased

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setBackground(litgreen);
        
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        
    }//GEN-LAST:event_jButton3MouseExited

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()){
          pass.setEchoChar((char)0); 
          jToggleButton1.setBackground(Color.red);
        }else{
          pass.setEchoChar('*'); 
          jToggleButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel message;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox<String> select;
    private javax.swing.JLabel showing;
    private javax.swing.JLabel showing1;
    // End of variables declaration//GEN-END:variables
}
