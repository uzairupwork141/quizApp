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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class MANAGEQUESTION extends javax.swing.JFrame {

    
    /**
     * Creates new form ADDQUESTION
     */
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    public MANAGEQUESTION() {
        initComponents();
        ConnectDB c = new ConnectDB();
        con = c.Connect();
        getcategory();
        
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
    
    
    
    
    
    
    public void search(){
        try{
            str=con.prepareStatement("SELECT * FROM `addquestion` WHERE ID=?");
            str.setString(1,search.getText());
            rs=str.executeQuery();
            if (rs.next()){
                
                ID.setText(rs.getString("ID"));
                QUESTION.setText(rs.getString("question"));
                CATEGORY.setSelectedItem(rs.getString("category"));
                a.setText(rs.getString("a"));
                b.setText(rs.getString("b"));
                c.setText(rs.getString("c"));
                answer.setText(rs.getString("answer"));
            }else{
                
                    JOptionPane.showMessageDialog(this,"DATA NOT AVALIBALE","ERROR",2);
            }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void clear(){
        this.dispose();
        MANAGEQUESTION a = new MANAGEQUESTION();
        a.setVisible(true);
    }
    
    
    
    
    public void UPDATE(){
       
        if ( QUESTION.getText().equals("") || a.getText().equals("") ||CATEGORY.getSelectedItem().equals("NONE")
                || b.getText().equals("") || c.getText().equals("") || answer.getText().equals("")){  
        JOptionPane.showMessageDialog(this,"INCOMPLETE ENTERY");
        }else{
                try{
                    str=con.prepareStatement("SELECT * FROM `addquestion` WHERE ID=?");
                    str.setString(1,ID.getText());
                    rs=str.executeQuery();
                    if (rs.next()){
                        str=con.prepareStatement("update `addquestion` set CATEGORY=?, QUESTION=?, a=?, b=?, c=?, ANSWER=? where ID="+ID.getText());
                        str.setString(1, CATEGORY.getSelectedItem().toString());
                        str.setString(2, QUESTION.getText());
                        str.setString(3, a.getText());
                        str.setString(4, b.getText());
                        str.setString(5, c.getText());
                        str.setString(6, answer.getText());
                        str.executeUpdate();
                        JOptionPane.showMessageDialog(this,"DATA UPDATED","SUCCESS",1);
                        clear();
                    }else{
                        JOptionPane.showMessageDialog(this,"This ID is not in system ","EMPTY",1);
                    }
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
                    }
                
        }
    }
         
    
    
    
    
    
    
    
    
    
    
    
     public void delete(){
        if(ID.getText().equals("")|| QUESTION.getText().equals("")){
            JOptionPane.showMessageDialog(this," EMPTY FIELD DETECTED ");
        }else{
            try{
                int id=Integer.parseInt(ID.getText());
                str=con.prepareStatement("SELECT * FROM `addquestion` WHERE ID=?");

                str.setInt(1,id);
                rs=str.executeQuery();
                if (rs.next()){
                    int p = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete"+CATEGORY.getSelectedItem()+" Question","Delete",JOptionPane.YES_NO_OPTION);
                    if (p==0){ 
                       str=con.prepareStatement("delete from `addquestion` where ID='"+id+"'");
                       str.executeUpdate();
                       JOptionPane.showMessageDialog(this,"Question IS DELETED SUCCESSFULLY","DELETED",3);
                       clear();
                    }else{
                        JOptionPane.showMessageDialog(this , "REQUEST CANCELED","DENIED",2);
                    }
        
                }else{
                        JOptionPane.showMessageDialog(this , "THIS DATA DOSE NOT EXIST\n      UNABLE TO DELET","NO DATA",2); 
                }
            }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
            }
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
        jPanel2 = new javax.swing.JPanel();
        CATEGORY = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "MANAGE QUESTION'S", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 50))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("OPTION a");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 90, 30));

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
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 340, 40));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUESTION");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 110, 30));

        QUESTION.setBackground(new java.awt.Color(0, 0, 0,150));
        QUESTION.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        QUESTION.setForeground(new java.awt.Color(255, 255, 255));
        QUESTION.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        QUESTION.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(QUESTION, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 680, 40));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OPTION b");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 90, 30));

        b.setBackground(new java.awt.Color(0, 0, 0,150));
        b.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        b.setForeground(new java.awt.Color(255, 255, 255));
        b.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 340, 40));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ANSWER");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 80, 30));

        answer.setBackground(new java.awt.Color(0, 0, 0,150));
        answer.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        answer.setForeground(new java.awt.Color(255, 255, 255));
        answer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 340, 40));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID#");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 40, 30));

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
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 120, 40));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("OPTION c");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 90, 30));

        c.setBackground(new java.awt.Color(0, 0, 0,150));
        c.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        c.setForeground(new java.awt.Color(255, 255, 255));
        c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 340, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CATEGORY.setBackground(new java.awt.Color(0, 0, 0,0));
        CATEGORY.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        CATEGORY.setForeground(new java.awt.Color(255, 0, 0));
        CATEGORY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE" }));
        CATEGORY.setToolTipText("");
        CATEGORY.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CATEGORY", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 24))); // NOI18N
        CATEGORY.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CATEGORY.setName(""); // NOI18N
        CATEGORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CATEGORYActionPerformed(evt);
            }
        });
        jPanel2.add(CATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 200, 80));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0,150));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/qz.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 4));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 830, 450));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 10, 50, 40));

        jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-edit-100.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, 100, 130));

        search.setBackground(new java.awt.Color(0, 0, 0,0));
        search.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 1, 24))); // NOI18N
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-search-20.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 40, 30));

        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton4.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-trash-100.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, 100, 120));

        jButton5.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton5.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-clear-100.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 100, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 590));

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
        
            MAINADMIN.kye=0;
            this.setVisible(false);
        
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
        UPDATE();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CATEGORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CATEGORYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CATEGORYActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
         jButton4.setBackground(Color.red);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        
        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        delete();
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setBackground(Color.ORANGE);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        jButton5.setBackground(new java.awt.Color(0, 0, 0,0));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MANAGEQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MANAGEQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MANAGEQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MANAGEQUESTION.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MANAGEQUESTION().setVisible(true);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
