/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class ADDQUESTION extends javax.swing.JFrame {

    
    /**
     * Creates new form ADDQUESTION
     */
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    public static int HKEY;
    
    public ADDQUESTION() {
        initComponents();
        ConnectDB c = new ConnectDB();
        con = c.Connect();
        getcategory();
        getid();
        
    }

    
    
    
    
    
    
    public void getid(){
        
        try{
            str=con.prepareStatement("select id from addquestion where id=(select max(id) from addquestion)");
            rs=str.executeQuery();
            if (rs.next()){
                int id = rs.getInt("ID");
                id++;
                ID.setText(""+id);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);

        }
        
    }
    
    
    
    
    
    
    
    
    
    public void getcategory(){
        
        try{
            str=con.prepareStatement("select* from `category`");
            rs=str.executeQuery();
            while(rs.next()){
                CATEGORY.addItem(rs.getString("CATEGORY"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);

        }
        
    
    
    }
    
    
    
    
    public void clear(){
        this.dispose();
        ADDQUESTION a = new ADDQUESTION();
        a.setVisible(true);
    }
    
    
    
    
    public void submit(){
       
        if (  QUESTION.getText().equals("") || a.getText().equals("") ||CATEGORY.getSelectedItem().equals("NONE")
                || b.getText().equals("") || c.getText().equals("") || answer.getText().equals("")){  
        JOptionPane.showMessageDialog(this,"INCOMPLETE ENTERY");
        }else{

                try{
                    str=con.prepareStatement("SELECT * FROM `addquestion` WHERE question = ?");
                    str.setString(1,QUESTION.getText());
                    rs=str.executeQuery();
                    if (rs.next()){
                        message.setText("This QUESTION Already Avalible In The System ");
                    }else{
                        str=con.prepareStatement("INSERT INTO `addquestion`(`CATEGORY`, `QUESTION`, `a`, `b`, `c`, `ANSWER`) VALUES(?,?,?,?,?,?)");
                        str.setString(1, CATEGORY.getSelectedItem().toString());
                        str.setString(2, QUESTION.getText());
                        str.setString(3, a.getText());
                        str.setString(4, b.getText());
                        str.setString(5, c.getText());
                        str.setString(6, answer.getText());
                        str.executeUpdate();
                        message.setText("");
                        JOptionPane.showMessageDialog(this,"DATA SAVED","SUCCESS",1);
                    }
                        clear();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
                    }
        }
    }
         
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        QUESTION = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        c = new javax.swing.JTextField();
        CATEGORY = new javax.swing.JComboBox<>();
        message = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ADD NEW QUESTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 50))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OPTION a");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 246, 90, 30));

        a.setBackground(new java.awt.Color(0, 0, 0,150));
        a.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        a.setForeground(new java.awt.Color(255, 255, 255));
        a.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 340, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUESTION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 196, 110, 30));

        QUESTION.setBackground(new java.awt.Color(0, 0, 0,150));
        QUESTION.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        QUESTION.setForeground(new java.awt.Color(255, 255, 255));
        QUESTION.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QUESTION.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(QUESTION, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 670, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OPTION b");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 296, 90, 30));

        b.setBackground(new java.awt.Color(0, 0, 0,150));
        b.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 340, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ANSWER");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 396, 80, 30));

        answer.setBackground(new java.awt.Color(0, 0, 0,150));
        answer.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        answer.setForeground(new java.awt.Color(255, 255, 255));
        answer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 340, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID#");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 146, 40, 30));

        ID.setEditable(false);
        ID.setBackground(new java.awt.Color(0, 0, 0,150));
        ID.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 120, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("OPTION c");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 346, 90, 30));

        c.setBackground(new java.awt.Color(0, 0, 0,150));
        c.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        c.setForeground(new java.awt.Color(255, 255, 255));
        c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 340, 40));

        CATEGORY.setBackground(new java.awt.Color(0, 0, 0,0));
        CATEGORY.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CATEGORY.setForeground(new java.awt.Color(255, 255, 255));
        CATEGORY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));
        CATEGORY.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "CATEGORY", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 24))); // NOI18N
        CATEGORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CATEGORYActionPerformed(evt);
            }
        });
        jPanel1.add(CATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 220, 80));

        message.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 810, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 220, 80));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0,150));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/qz.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 4));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 830, 410));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 50, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-done-36.png"))); // NOI18N
        jButton2.setText("SUBMIT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 190, 70));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-clear-50.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 50, 50));

        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-database-60.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 490, 60, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (HKEY==0){
            MAINADMIN.kye=0;
            this.dispose();
        }else{
            MAINADMIN.showmasseg();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
         jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        submit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CATEGORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATEGORYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CATEGORYActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(HKEY == 0){
            questionhistory qh = new questionhistory();
            qh.setVisible(true);
            HKEY=1;
        }else{
            JOptionPane.showMessageDialog(rootPane, "ALREADY OPEN");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ADDQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDQUESTION().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CATEGORY;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField QUESTION;
    private javax.swing.JTextField a;
    private javax.swing.JTextField answer;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
