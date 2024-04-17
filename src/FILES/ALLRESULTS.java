/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User1
 */
public class ALLRESULTS extends javax.swing.JFrame {

    /**
     * Creates new form ALLRESULTS
     */
    String ID;
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    ArrayList<Integer> IDs = new ArrayList<>(); 
    public ALLRESULTS() 
    {
        initComponents();
        con = new ConnectDB().Connect();
        getALLDATA();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public void getdata(String I){
    
        
        int c;
        try {
            str=con.prepareStatement ("SELECT * FROM studentdetail WHERE ID='"+I+"'");
            rs=str.executeQuery();
                    if (rs.next()){
                    String add=(rs.getString("ID"));
                    ID1.setText(add);
                    String add1=(rs.getString("NAME"));
                    NAME.setText(add1);
                    String add2=(rs.getString("USERNAME"));
                    USERNAME.setText(add2);
                    String add3=(rs.getString("EMAIL"));
                    EMAIL.setText(add3);
                    String add4=(rs.getString("PHONE"));
                    PHONE.setText(add4);
                    byte[] Img = rs.getBytes("img");
                        //Resize The ImageIcon
                        ImageIcon image = new ImageIcon(Img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(220,220,Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        img.setIcon(newImage);
                    getresults(I);
                    }else {
                        JOptionPane.showMessageDialog(this,"NO DATA AVALIBLE","NO DATA",2);
                    }
           
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    
    public void getresults(String I){
        int c;
        try {

            str=con.prepareStatement ("SELECT * FROM `result` where ID="+I);
            

           rs=str.executeQuery();
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            c=rss.getColumnCount();
            DefaultTableModel df=(DefaultTableModel)jTable2.getModel();
            df.setRowCount(0);
                    
            while (rs.next()){
                Vector v2=new Vector();
                for (int a=1;a<=c;a++){
                    
                    v2.add(rs.getString("marks"));
                     v2.add(rs.getString("category"));
                    v2.add(rs.getString("timetaken"));
                    v2.add(rs.getString("date"));
                  
                     
                }
                df.addRow(v2);
            }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    public void getALLDATA()
     {
        int c;
        try {
            str=con.prepareStatement ("SELECT DISTINCT ID from result ORDER BY ID ASC");
            rs=str.executeQuery();
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            c=rss.getColumnCount();
            while (rs.next()){
                for (int a=1;a<=c;a++){
                    IDs.add(rs.getInt("ID"));                   
                }
                
            }
            DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            for(int i=0;i<IDs.size();i++){
                int I=IDs.get(i);
                str=con.prepareStatement ("SELECT * FROM `studentdetail` where ID="+I);
                rs=str.executeQuery();
                rss=(ResultSetMetaData) rs.getMetaData();
                c=rss.getColumnCount();
                
                while (rs.next()){
                    Vector v2=new Vector();
                    for (int a=1;a<=c;a++){
                        v2.add(String.valueOf(rs.getInt("ID")));
                        v2.add(rs.getString("NAME"));
                        v2.add(rs.getString("USERNAME"));
                        v2.add(rs.getString("PHONE"));
                    }
                    df.addRow(v2);
                }
            }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        EMAIL = new javax.swing.JLabel();
        PHONE = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        ID1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ID2 = new javax.swing.JLabel();
        ID3 = new javax.swing.JLabel();
        ID4 = new javax.swing.JLabel();
        ID5 = new javax.swing.JLabel();
        ID6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "ALL RESULTS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 55))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "USERNAME", "PHONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(50);
        jTable1.setShowGrid(true);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 760, 500));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-exam-100.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 90, 100));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "ALL ATTEMPTS ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 24))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MARKS", "SUBJECT", "TIME TAKEN", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 140));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 450, 190));

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDesktopPane1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 220));

        jPanel3.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 220));

        EMAIL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EMAIL.setText("EMAIL$");
        jPanel3.add(EMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 200, 40));

        PHONE.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PHONE.setText("PHONE$");
        jPanel3.add(PHONE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 40));

        USERNAME.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        USERNAME.setText("USER$");
        jPanel3.add(USERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 200, 40));

        NAME.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NAME.setText("NAME$");
        jPanel3.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 220, 40));

        ID1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID1.setText("ID$");
        jPanel3.add(ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 150, 40));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 2, 110));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 450, 2));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        ID2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID2.setText("EMAIL");
        jPanel3.add(ID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 130, 20));

        ID3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID3.setText("ID #");
        jPanel3.add(ID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 40, 40));

        ID4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID4.setText("USERNAME");
        jPanel3.add(ID4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 100, 20));

        ID5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID5.setText("NAME");
        jPanel3.add(ID5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, 20));

        ID6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ID6.setText("PHONE");
        jPanel3.add(ID6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 50, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 470, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MAINADMIN.kye=0;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df=(DefaultTableModel)jTable1.getModel();
        int SI=jTable1.getSelectedRow();
        String i =df.getValueAt(SI,0).toString();
        getdata(i);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ALLRESULTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ALLRESULTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ALLRESULTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ALLRESULTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ALLRESULTS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EMAIL;
    private javax.swing.JLabel ID1;
    private javax.swing.JLabel ID2;
    private javax.swing.JLabel ID3;
    private javax.swing.JLabel ID4;
    private javax.swing.JLabel ID5;
    private javax.swing.JLabel ID6;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel PHONE;
    private javax.swing.JLabel USERNAME;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
