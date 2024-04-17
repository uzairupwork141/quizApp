/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User1
 */
public class CATEGORY1 extends javax.swing.JFrame {

    

        /**
     * Creates new form CATEGORY1
     */
    public static int HKYE=0;
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    
    
    public CATEGORY1() {
        initComponents();
        ConnectDB c = new ConnectDB();
        con = c.Connect();
        getid();
        MAINADMIN m =new MAINADMIN();
        System.out.println(m.getKye());
    }
    
    
   
    
    public void getid(){
        
         try{
            str=con.prepareStatement("select ID from `category` where ID =(select max(id) from `category`)");
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
    
    
    
    
    
    
    public void ADD(){
        if(ID.getText().equals("")||NAME.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Empty Field Detected","error",2);
        }else{
            
            try{
                    str=con.prepareStatement("SELECT * FROM `category` WHERE ID=? or category=?");

                    str.setString(1,ID.getText());
                    str.setString(2,NAME.getText());
                    rs=str.executeQuery();
                    if (rs.next()){
                        message.setText("This ID or NAME is Already In Avalible ");
                    }else{
                        str=con.prepareStatement("INSERT INTO `category`(`CATEGORY`)VALUES(?)");
                        
                        str.setString(1, NAME.getText());
                        
                        str.executeUpdate();
                        JOptionPane.showMessageDialog(this,"DATA SAVED","SUCCESS",1);
                        clear();
                    }
                        
                    }catch(SQLException  e){
                        
                            JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
                        
                        
                    }
        }
        
        
    }
    
    
    
    
    
    public void search(){
        try{
            str=con.prepareStatement("SELECT * FROM `category` WHERE ID=?");
            str.setString(1,search.getText());
            rs=str.executeQuery();
            if (rs.next()){
                ID.setEditable(false);
                ID.setText(rs.getString("ID"));
                NAME.setText(rs.getString("CATEGORY"));
            }else{
                
                    JOptionPane.showMessageDialog(this,"DATA NOT AVALIBALE","ERROR",2);
            }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
        }
        
        
    }
    
    
    
    
    
    
    public void Update(){
        try{
            str=con.prepareStatement("SELECT * FROM `category` WHERE ID=?");
            str.setString(1,ID.getText());
            rs=str.executeQuery();
            if (rs.next()){
                str=con.prepareStatement("Update `category` set CATEGORY=? WHERE ID="+ID.getText());
                ID.setEditable(true);
                str.setString(1,NAME.getText());
                str.executeUpdate();
                JOptionPane.showMessageDialog(this, "UPDATE Success ");
                message.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "DATA DOSE NOT EXIST PLEASE SUBMIT FIRST ");
            }
            
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
        }
        
        
    }
    
    
    
    
    
    public void clear(){
        this.dispose();
        new CATEGORY1().setVisible(true);
                
    }
    
    
    
    
    public void delete(){
        if(ID.getText().equals("")|| NAME.getText().equals("")){
            JOptionPane.showMessageDialog(this," EMPTY FIELD DETECTED ");
        }else{
            try{
                int id=Integer.parseInt(ID.getText());
                str=con.prepareStatement("SELECT * FROM `category` WHERE ID=?");

                str.setInt(1,id);
                rs=str.executeQuery();
                if (rs.next()){
                    int p = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "+NAME.getText()+" DATA","Delete",JOptionPane.YES_NO_OPTION);
                    if (p==0){ 
                       str=con.prepareStatement("delete from `category` where ID='"+id+"'");
                       str.executeUpdate();
                       str=con.prepareStatement("delete from `addquestion` where Category='"+NAME.getText()+"'");
                       str.executeUpdate();
                       JOptionPane.showMessageDialog(this,"CATEGORY AND ITS QUESTION ARE DELETED","SUCCESS",3);
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
        jPanel2 = new javax.swing.JPanel();
        ID = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        message = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "ADD NEW CATEGORY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 50))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(827, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID.setEditable(false);
        ID.setBackground(new java.awt.Color(0, 0, 0,150));
        ID.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 120, 50));

        NAME.setBackground(new java.awt.Color(0, 0, 0,150));
        NAME.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        NAME.setForeground(new java.awt.Color(255, 255, 255));
        NAME.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 320, 50));

        message.setBackground(new java.awt.Color(255, 0, 0));
        message.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID #");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, 50));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 120, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/qz.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 260));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 550, 260));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 50)); // NOI18N
        jButton1.setText("ADD");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 150, -1));

        search.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-search-20.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 40, 30));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-clear-50.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 50));

        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-edit-50.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 50));

        jButton5.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-trash-can-50.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 60, 50));

        jButton6.setBackground(new java.awt.Color(0, 0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 12, 50, 40));

        jButton7.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-database-60.png"))); // NOI18N
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 70, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 838, 436));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here
       if (HKYE==0){
            MAINADMIN.kye=0;
            this.dispose();
       }else{
          JOptionPane.showMessageDialog(rootPane, "PLEASE CLOSE HISTORY ");
       }
       
      
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ADD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        search();
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Update();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(HKYE==0){
            categoryhistory ch = new categoryhistory();
            ch.setVisible(true);
            HKYE=1;
        }else{
                MAINADMIN.showmasseg();
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
        
        
        jButton7.setBackground(Color.YELLOW);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        // TODO add your handling code here:
        
       jButton7.setBackground( new java.awt.Color(0, 0, 0,0));
        
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        
         jButton1.setBackground(Color.GREEN);
        
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        
         jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        
    }//GEN-LAST:event_jButton1MouseExited

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
            java.util.logging.Logger.getLogger(CATEGORY1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CATEGORY1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CATEGORY1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CATEGORY1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CATEGORY1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField NAME;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel message;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
