/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User1
 */
public class allstudents extends javax.swing.JFrame {

    /**
     * Creates new form allstudents
     */
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    public allstudents() {
        initComponents();
        con= new ConnectDB().Connect();
        getALLDATA();
    }
    
    
    
    
    
    
    
    public void getALLDATA()
    {
        int c;
        try {
           
          
            str=con.prepareStatement ("SELECT* from studentdetail ");
            rs=str.executeQuery();
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            c=rss.getColumnCount();
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
                
            while (rs.next()){
                Vector v2=new Vector();
                for (int a=1;a<=c;a++){
                   v2.add(rs.getString("ID"));
                   v2.add(rs.getString("NAME"));
                   v2.add(rs.getString("USERNAME"));
                   v2.add(rs.getString("PASSWORD"));

                }
                df.addRow(v2);
                
            }
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    
    
    
    public void tableclick(){
        DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
         int srow = jTable1.getSelectedRow();
         String i=df.getValueAt(srow, 0).toString();
         ID.setText(df.getValueAt(srow, 0).toString());

        try {
            
            str=con.prepareStatement ("SELECT * FROM `studentdetail` WHERE ID='"+i+"'");
            rs=str.executeQuery();
                    if (rs.next()){
                        ID.setText(rs.getString("ID"));
                        NAME.setText(rs.getString("NAME"));
                        FATHER.setText(rs.getString("LASTNAME"));
                        AGE.setText(rs.getString("AGE"));
                        PHONE.setText(rs.getString("PHONE"));
                        CNIC.setText(rs.getString("CNIC"));
                        EMAIL.setText(rs.getString("EMAIL"));
                        GENDER.setText(rs.getString("GENDER"));
                        byte[] Img = rs.getBytes("img");
                        //Resize The ImageIcon
                        ImageIcon image = new ImageIcon(Img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(190,190,Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        img.setIcon(newImage);
                        
                        
                    }else 
                    {
                        JOptionPane.showMessageDialog(this,"NO DATA AVALIBLE","NO DATA",2);
                    }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
        
        
        
    }
    
    
    
    
    
    
     
     
    public void delete (){
         try{
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            int row=jTable1.getSelectedRow();
            
            String id = (jTable1.getModel().getValueAt(row, 0).toString());
            String nna = (jTable1.getModel().getValueAt(row, 1).toString());
            int p = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + nna + " DATA?","Delete",JOptionPane.YES_NO_OPTION);
            if (p==0){
                String Str="DELETE FROM `studentdetail` WHERE ID = "+ id ;
                str=con.prepareStatement(Str);
                str.execute();
                String RStr="DELETE FROM `result` WHERE ID ="+ id ;
                str=con.prepareStatement(RStr);
                str.execute();
                JOptionPane.showMessageDialog(this,"Sucessfully Deleted!");
                getALLDATA();
                clear();
            }else{
                JOptionPane.showMessageDialog(this,"Request Cancelled!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
     
     
     
     
     
     
    
    public void search(){
        
         int c; 
            try
            {
                str=con.prepareStatement ("SELECT * FROM `studentdetail` where NAME LIKE '%"+src.getText()+"%'");


                ResultSet rs=str.executeQuery();
                java.sql.ResultSetMetaData rss=rs.getMetaData();
                c=rss.getColumnCount();
                DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
                df.setRowCount(0);
                
                    while (rs.next()){
                        Vector v2=new Vector();
                        for (int a=1;a<=c;a++){

                            v2.add(String.valueOf(rs.getInt("ID")));
                            v2.add(rs.getString("NAME"));
                            v2.add(rs.getString("USERNAME"));
                            v2.add(rs.getString("PASSWORD"));
                          
                        }
                        df.addRow(v2);
                    }
               
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
            }
            
        
    }
     
     
    
    
    
    public void clear(){
            getALLDATA();
            img.setIcon(null);
            ID.setText(null);
            NAME.setText(null);
            FATHER.setText(null);
            AGE.setText(null);
            GENDER.setText(null);
            CNIC.setText(null);
            EMAIL.setText(null);
            PHONE.setText(null);
        
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        FATHER = new javax.swing.JLabel();
        CNIC = new javax.swing.JLabel();
        AGE = new javax.swing.JLabel();
        GENDER = new javax.swing.JLabel();
        PHONE = new javax.swing.JLabel();
        EMAIL = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ALL REGISTERED STUDENTS ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 36))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));
        jTable1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "USERNAME", "PASSWORD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new java.awt.Color(102, 255, 102));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 880, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-students-100.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 100, 70));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-trash-100.png"))); // NOI18N
        jButton1.setText("DELETE STUDENT");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 240, 90));

        jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 50, 40));

        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jDesktopPane1.add(img);
        img.setBounds(0, 0, 190, 190);

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 190, 190));

        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 150, 110, 50));

        NAME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NAME.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 300, 50));

        FATHER.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        FATHER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FATHER.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "LAST NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(FATHER, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 300, 50));

        CNIC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CNIC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CNIC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ID#", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(CNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 300, 50));

        AGE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        AGE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AGE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "AGE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(AGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 300, 50));

        GENDER.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GENDER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GENDER.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "GENDER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(GENDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 300, 50));

        PHONE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PHONE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PHONE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PHONE NO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(PHONE, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 300, 50));

        EMAIL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        EMAIL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EMAIL.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "EMAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel1.add(EMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 300, 50));

        src.setBackground(new java.awt.Color(255, 153, 51));
        src.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        src.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        src.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "SEARCH BY NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        src.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcActionPerformed(evt);
            }
        });
        src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srcKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                srcKeyTyped(evt);
            }
        });
        jPanel1.add(src, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 60));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-clear-50.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 550, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(Color.red);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MAINADMIN.kye=0;
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        tableclick();
                
                
    }//GEN-LAST:event_jTable1MouseClicked

    private void srcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcActionPerformed

    private void srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyReleased
        // TODO add your handling code here:
        if (src.getText().equals("")){
            getALLDATA();
            clear();
        }else{
            search();
        }
    }//GEN-LAST:event_srcKeyReleased

    private void srcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_srcKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clear();
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
            java.util.logging.Logger.getLogger(allstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allstudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AGE;
    private javax.swing.JLabel CNIC;
    private javax.swing.JLabel EMAIL;
    private javax.swing.JLabel FATHER;
    private javax.swing.JLabel GENDER;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel PHONE;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField src;
    // End of variables declaration//GEN-END:variables
}
