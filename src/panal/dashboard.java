/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package panal;

import FILES.ConnectDB;
import FILES.SETTING;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHABBIR TRADERS
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    PreparedStatement str1;
    ResultSet rs1;
    public dashboard() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        con= new ConnectDB().Connect();
        GetAllData("addquestion",tquestion,jLabel8);
        GetAllData("category",Tsubject,jLabel10);
        getitems();
    }
    private int xMouse;
    private int yMouse;
    static int n,thou,hun,tens,ones,zero,elevens;
    
   
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    
    public void getitems(){
        int c;
        try {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            str=con.prepareStatement ("SELECT * FROM `category`");
            rs=str.executeQuery();
            java.sql.ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();
            model.setRowCount(0);
            while (rs.next())
            {
               
                    String sno = String.valueOf(rs.getInt("ID"));
                    String ctg = rs.getString("category");
                    str1=con.prepareStatement ("SELECT count(*) from `addquestion` where CATEGORY ='"+ctg+"'");
                    rs1=str1.executeQuery();
                    rs1.next();
                    String Qno = String.valueOf(rs1.getInt(1));
                    Object[] row = { sno,ctg,Qno};
                    model.addRow(row);
            }
        }catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
      
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    public void NUM_WORD(int n,JLabel l){
        if (n==0){
   			
   			switch (n){
   				 case 0: l.setText(l.getText()+"Zero");break;
   				
   				}
   				}
   	
   		if ((n>=100) && (n<=3000)){
   			
   			thou = n/1000;
   			n = n%1000;
   			hun = n/100;
   			n = n%100;
   			
   			switch(thou){
   				
   				case 1:l.setText(l.getText()+"One Thousand ");break;
   				case 2:l.setText(l.getText()+"Two Thousand ");break;
   				case 3:l.setText(l.getText()+"Three Thousand ");break;		
   			}
   			
   			
   			switch (hun) {
   				case 1:l.setText(l.getText()+"One Hundred ");break;
   				case 2:l.setText(l.getText()+"Two Hundred ");break;
   				case 3:l.setText(l.getText()+"Three Hundred ");break;
   				case 4:l.setText(l.getText()+"Four Hundred ");break;
   				case 5:l.setText (l.getText()+"Five Hundred ");break;	
   				case 6:l.setText(l.getText()+"Six Hundred ");break;
   				case 7:l.setText(l.getText()+"Seven Hundred ");break;
   				case 8:l.setText	(l.getText()+"Eight Hundred ");break;
   				case 9:l.setText	(l.getText()+"Nine Hundred ");break;
   				
   							
   			}
   		}
   		
   					
	if ((n>10) && (n<20)){
		
		tens = n / 10;
		ones = n;
		elevens = n % 10;
		
		
		switch (elevens){
				case 1:l.setText(l.getText()+"Eleven ");break;
   				case 2:l.setText(l.getText()+"Twelve ");break;
   				case 3:l.setText(l.getText()+"Thirteen ");break;
   				case 4:l.setText(l.getText()+"Fourteen ");break;
   				case 5:l.setText(l.getText()+"Fifteen ");break;	
   				case 6:l.setText(l.getText()+"Sixteen ");break;
   				case 7:l.setText(l.getText()+"Seventeen ");break;
   				case 8:l.setText(l.getText()+"Eighteen ");break;
   				case 9:l.setText(l.getText()+"Nineteen ");break;
   				}
		}
		if (n>3000){
			System.out.print("INVALID INPUT");
		}
		
	else {
		tens = n/10;
		n = n%10;
		ones = n;
		
		switch (tens) {
			
			case 1:l.setText(l.getText()+"Ten ");break;
			case 2:l.setText(l.getText()+"Twenty ");break;
			case 3:l.setText(l.getText()+"Thirty ");break;
		
			case 4:l.setText(l.getText()+"Fourty ");break;
			case 5:l.setText(l.getText()+"Fifty ");break;
			case 6:l.setText(l.getText()+"Sixty ");break;
			case 7:l.setText(l.getText()+"Seventy ");break;
			case 8:l.setText(l.getText()+"Eighty ");break;
			case 9:	l.setText(l.getText()+"Ninety ");break;			
		}
		switch (ones){
			
			case 1: l.setText(l.getText()+"One ");break;
			case 2:l.setText(l.getText()+"Two ");break;
			case 3:l.setText(l.getText()+"Three ");break;
		
			case 4:l.setText(l.getText()+"Four ");break;
			case 5:l.setText(l.getText()+"Five ");break;
			case 6:l.setText(l.getText()+"Six ");break;
			case 7:l.setText(l.getText()+"Seven ");break;
			case 8:l.setText(l.getText()+"Eight ");break;
			case 9:l.setText(l.getText()+"Nine ");break;
			
		}
	
	}
        
    }
    
    
    
    
      
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    
    
    
    public void GetAllData(String tbl,JLabel Nlbl,JLabel Wlbl)
    {
        int c;
        try {
           
          
            str=con.prepareStatement ("SELECT count(*) from `"+tbl+"` ");
            rs=str.executeQuery();
            
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            rs.next();
            c = rs.getInt(1);
            Nlbl.setText(""+c);
            NUM_WORD(c,Wlbl);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
      
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    public void GetSpecificData( String tbl , String field , String eqlto , JLabel Nlbl , JLabel Wlbl )
    {
        int c;
        try {
           
          
            str=con.prepareStatement ("SELECT count(*) from `"+tbl+"` where "+field+"='"+eqlto+"'");
            rs=str.executeQuery();
            
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            rs.next();
            c = rs.getInt(1);
            Nlbl.setText(""+c);
            NUM_WORD(c,Wlbl);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------------------------------
    
    public void GettblData(){
        int c;
        try {
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            str=con.prepareStatement ("SELECT * FROM `studentdetail`");
            rs=str.executeQuery();
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            c=rss.getColumnCount();
            model.setRowCount(0);
            while (rs.next())
            {
               
                    String sno = String.valueOf(rs.getInt("ID"));
                    String name = rs.getString("name");
                    String status = rs.getString("Status");
                    Object[] row = { sno,name,status};
                    model.addRow(row);
            }
        }catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    
    public void GettblData(String selected,String Data){
        int c;
        try {
            DefaultTableModel model = (DefaultTableModel) table2.getModel();
            str=con.prepareStatement ("SELECT * FROM `studentdetail` where "+selected+" LIKE '%"+Data+"%'");
            rs=str.executeQuery();
            ResultSetMetaData rss=(ResultSetMetaData) rs.getMetaData();
            c=rss.getColumnCount();
            model.setRowCount(0);
            while (rs.next())
            {
               
                    String sno = String.valueOf(rs.getInt("ID"));
                    String name = rs.getString("name");
                    String status = rs.getString("Status");
                    Object[] row = { sno,name,status};
                    model.addRow(row);
            }
        }catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    public void showMsgBox(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table21 = new panal.Table2();
        table22 = new panal.Table2();
        bgpanal1 = new panal.bgpanal();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnpanl2 = new panal.btnpanl();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pane13 = new panal.pane1();
        pane24 = new panal.pane2();
        jLabel5 = new javax.swing.JLabel();
        tquestion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pane25 = new panal.pane2();
        Tsubject = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bgpanal2 = new panal.bgpanal();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new panal.Table2();
        pane31 = new panal.pane3();
        pane21 = new panal.pane2();
        tstudentlabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tstudent = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pane22 = new panal.pane2();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tactive = new javax.swing.JLabel();
        tactivelabel = new javax.swing.JLabel();
        pane23 = new panal.pane2();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tdeactive = new javax.swing.JLabel();
        tdeactivelabel = new javax.swing.JLabel();
        bgpanal3 = new panal.bgpanal();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new panal.Table2();
        jLabel22 = new javax.swing.JLabel();
        pane11 = new panal.pane1();
        jLabel12 = new javax.swing.JLabel();
        SEARCHtxt = new javax.swing.JTextField();
        pane15 = new panal.pane1();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        pane14 = new panal.pane1();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgpanal1.setBackground(new java.awt.Color(255, 255, 255));
        bgpanal1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jLabel2.setText("EXIT");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 0, 100, 60));

        bgpanal1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 230, 60));

        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-menu-squared-50.png"))); // NOI18N
        jLabel3.setText("STUDENT'S");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 100));

        bgpanal1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 230, 100));

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-menu-squared-50.png"))); // NOI18N
        jLabel1.setText("QUESTION & SUBJECT");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 100));

        bgpanal1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 100));
        bgpanal1.add(btnpanl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 680));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane13.setForeground(new java.awt.Color(51, 255, 255));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel5.setText("AVAILABLE IN SYSTEM");
        pane24.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        tquestion.setFont(new java.awt.Font("Lucida Bright", 1, 48)); // NOI18N
        tquestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tquestion.setText("0");
        pane24.add(tquestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 360, -1));

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel6.setText("TOTAL NUMBER OF QUESTION'S");
        pane24.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane24.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 360, 40));

        pane13.add(pane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 360, 230));

        Tsubject.setFont(new java.awt.Font("Lucida Bright", 1, 48)); // NOI18N
        Tsubject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tsubject.setText("0");
        pane25.add(Tsubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 360, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel9.setText("TOTAL NUMBER OF SUBJECT'S");
        pane25.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel7.setText("REGISTERED IN SYSTEM");
        pane25.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 50, 230, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane25.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 360, 40));

        pane13.add(pane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 360, 230));

        bgpanal2.setBackground(new java.awt.Color(255, 255, 255));
        bgpanal2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBorder(null);
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COURSE NO", "NAME", "NO OF QUESTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        table1.setOpaque(true);
        table1.setSelectionBackground(new java.awt.Color(153, 255, 255));
        table1.setShowGrid(true);
        table1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(table1);

        bgpanal2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 850, 300));

        pane13.add(bgpanal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 870, 320));

        jTabbedPane2.addTab("tab1", pane13);

        tstudentlabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        tstudentlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane21.add(tstudentlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 320, 30));

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel13.setText("TOTAL NUMBER OF STUDENT'S");
        pane21.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 310, -1));

        tstudent.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        tstudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tstudent.setText("0");
        pane21.add(tstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 320, 60));

        jLabel21.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("REGISTERED IN SYSTEM");
        pane21.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 320, -1));

        pane31.add(pane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 230));

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ACTIVE");
        pane22.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 50, 330, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("TOTAL NUMBER OF STUDENT'S");
        pane22.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, -1));

        tactive.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        tactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tactive.setText("0");
        pane22.add(tactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 320, 60));

        tactivelabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        tactivelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane22.add(tactivelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 320, 30));

        pane31.add(pane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 320, 230));

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("DEACTIVE");
        pane23.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, -1));

        jLabel17.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("TOTAL NUMBER OF STUDENT'S");
        pane23.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 310, -1));

        tdeactive.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        tdeactive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tdeactive.setText("0");
        pane23.add(tdeactive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 60));

        tdeactivelabel.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        tdeactivelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pane23.add(tdeactivelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 310, 30));

        pane31.add(pane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 310, 230));

        bgpanal3.setBackground(new java.awt.Color(255, 255, 255));
        bgpanal3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REG NO", "NAME", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        table2.setSelectionBackground(new java.awt.Color(51, 255, 255));
        table2.setShowGrid(true);
        table2.setShowVerticalLines(false);
        jScrollPane2.setViewportView(table2);

        bgpanal3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 700, 240));

        jLabel22.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel22.setText("STUDENTS REGISTERED IN SYSTEM");
        bgpanal3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        pane11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ACTIVE");
        pane11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, 40));

        bgpanal3.add(pane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 160, 40));

        SEARCHtxt.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        SEARCHtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SEARCHtxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SEARCHtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SEARCHtxtKeyReleased(evt);
            }
        });
        bgpanal3.add(SEARCHtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 240, 60));

        pane15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pane15MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("DEACTIVE");
        pane15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        bgpanal3.add(pane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 160, 40));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-search-20.png"))); // NOI18N
        jLabel4.setText("SEARCH");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        bgpanal3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 120, 40));

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0,0));
        jComboBox1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REG NO", "NAME" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bgpanal3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 240, 60));

        pane31.add(bgpanal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 970, 310));

        jTabbedPane2.addTab("tab2", pane31);

        jPanel5.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1030, 630));

        bgpanal1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1030, 600));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUESTION & SUBJECT");
        pane14.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 980, 60));

        bgpanal1.add(pane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 1030, 60));

        getContentPane().add(bgpanal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
     
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
         jTabbedPane2.setSelectedComponent(pane13);
         jLabel11.setText(jLabel1.getText());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jPanel1.setOpaque(true);
        jPanel1.setBackground(new Color(255,255,255,70));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        SETTING.Ky=0;
        dispose ();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jPanel2.setOpaque(true);
        jPanel2.setBackground(new Color(255,255,255,70));
        jLabel2.setForeground(Color.YELLOW);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jPanel2.setOpaque(false);
        jPanel2.setBackground(new Color(0,0,0,0));
        jLabel2.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0,0,0,0));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
         jPanel3.setOpaque(true);
        jPanel3.setBackground(new Color(255,255,255,70));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jPanel3.setOpaque(false);
        jPanel3.setBackground(new Color(0,0,0,0));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        tstudentlabel.setText("");
        tactivelabel.setText("");
        tdeactivelabel.setText("");
        jTabbedPane2.setSelectedComponent(pane31);
        jLabel11.setText(jLabel3.getText());
        GetAllData("studentdetail",tstudent,tstudentlabel);
        GetSpecificData("studentdetail","status","Active",tactive,tactivelabel);
        GetSpecificData("studentdetail","status","Deactive",tdeactive,tdeactivelabel);
        GettblData();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setForeground(Color.red);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem().equals("REG NO")){
            GettblData("ID",SEARCHtxt.getText());
        }else if (jComboBox1.getSelectedItem().equals("NAME")){
            GettblData("NAME",SEARCHtxt.getText());
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void SEARCHtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SEARCHtxtKeyReleased
        // TODO add your handling code here:
        if (SEARCHtxt.getText().equals(null)){
            GettblData();
        }
    }//GEN-LAST:event_SEARCHtxtKeyReleased

    private void pane11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane11MouseClicked
        // TODO add your handling code here:
        showMsgBox("Under devolpment");

    }//GEN-LAST:event_pane11MouseClicked

    private void pane15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pane15MouseClicked
        // TODO add your handling code here:
        showMsgBox("Under devolpment");
    }//GEN-LAST:event_pane15MouseClicked

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SEARCHtxt;
    private javax.swing.JLabel Tsubject;
    private panal.bgpanal bgpanal1;
    private panal.bgpanal bgpanal2;
    private panal.bgpanal bgpanal3;
    private panal.btnpanl btnpanl2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private panal.pane1 pane11;
    private panal.pane1 pane13;
    private panal.pane1 pane14;
    private panal.pane1 pane15;
    private panal.pane2 pane21;
    private panal.pane2 pane22;
    private panal.pane2 pane23;
    private panal.pane2 pane24;
    private panal.pane2 pane25;
    private panal.pane3 pane31;
    private panal.Table2 table1;
    private panal.Table2 table2;
    private panal.Table2 table21;
    private panal.Table2 table22;
    private javax.swing.JLabel tactive;
    private javax.swing.JLabel tactivelabel;
    private javax.swing.JLabel tdeactive;
    private javax.swing.JLabel tdeactivelabel;
    private javax.swing.JLabel tquestion;
    private javax.swing.JLabel tstudent;
    private javax.swing.JLabel tstudentlabel;
    // End of variables declaration//GEN-END:variables
}
