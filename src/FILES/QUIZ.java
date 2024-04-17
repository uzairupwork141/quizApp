/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FILES;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;  
/**
 *
 * @author User1
 */

public class QUIZ extends javax.swing.JFrame {

    /**
     * Creates new form QUIZ
     */
    Connection con ;
    PreparedStatement str;
    ResultSet rs;
    int index =0;
    int markes=0;
    Timer timer;
    private  String ID1;    
    private  String CATEGORY1;
    public int min=9;
    public int sec=60;
    private  String ANSWER;
    ArrayList<Integer> QIDs = new ArrayList<>();   
    int[] CHECK=new int[10];
    char[] ans=new char[10]; 
    public QUIZ() {
        initComponents();
        timer();
        jButton3.hide();
        jButton1.hide();
        con = new ConnectDB().Connect();
        getdata();
        getQIDs();
        currentdate();
        getQuestion();
    }
    public QUIZ(String i,String n,String c) {
        this.ID1=i;
        this.CATEGORY1=c;
        
        initComponents();
        con = new ConnectDB().Connect();
        getdata();
        timer();
        currentdate();
        getQIDs();
        getQuestion();
        jButton3.hide();
        jButton1.hide();
    }
    
    public void timer(){
        String id = ID.getText();
        String name = NAME.getText();
        String category = CATEGORY.getText();
        timer = new Timer (1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                SEC.setText(String.valueOf(sec));
                MIN.setText(String.valueOf(min)); 
                
                if(sec==0)
                {
                    sec=60;
                    min--;
                    if(min<0)
                    {
                        timer.stop();
                        SUBMITCHECK();
                        question.setText("NONE");
                        A.setText("NONE");
                        B.setText("NONE");
                        C.setText("NONE");
                        jButton3.hide();
                        jButton2.hide();
                        jButton1.show();
                    }
                    
                }
                
                sec--;
                if (Integer.parseInt(QNO.getText())>=10){
                    jButton3.show();
                    jButton2.hide();
                }else{
                    jButton3.hide();
                    jButton2.show();
                }
            }
        });
        timer.start();

    }
    
    
    
    
    
    
    
    
    
     public void currentdate(){
            
                            Calendar cal=new GregorianCalendar();
                            int month=cal.get(Calendar.MONTH);
                            int year =cal.get(Calendar.YEAR);
                            int day=cal.get(Calendar.DAY_OF_MONTH);
                            DATE.setText(day+"/"+month+"/"+year);
                        
                    
    }
    
     
     
     
    
    
    public void getdata(){
        try {
            str=con.prepareStatement ("SELECT * FROM studentdetail WHERE ID='"+ID1+"'");
            rs=str.executeQuery();
                    if (rs.next()){
                    String add=(rs.getString("ID"));
                    ID.setText(add);
                    String add1=(rs.getString("NAME"));
                    NAME.setText(add1);
                    CATEGORY.setText(CATEGORY1);
                    byte[] Img = rs.getBytes("img");
                        //Resize The ImageIcon
                        ImageIcon image = new ImageIcon(Img);
                        Image im = image.getImage();
                        Image myImg = im.getScaledInstance(220,220,Image.SCALE_SMOOTH);
                        ImageIcon newImage = new ImageIcon(myImg);
                        img.setIcon(newImage);
                    }else {
                        JOptionPane.showMessageDialog(this,"NO DATA AVALIBLE","NO DATA",2);
                    }
           
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void getQIDs(){
        int c;
        try {
            str=con.prepareStatement ("SELECT ID FROM addquestion WHERE CATEGORY='"+CATEGORY.getText()+"' order by rand() limit 10");
            rs=str.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();
            while(rs.next()){
                for (int a=1;a<=c;a++){
                    QIDs.add(rs.getInt("ID"));
                }
            }
           for (int i = 0; i < QIDs.size();i++) 
                { 
                    System.out.println(QIDs.get(i)); 
                }
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex,"CONNECTION ",3);
        }
        
        
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void getQuestion(){
        
        int CURRENTQID=QIDs.get(index);
         try {
            str=con.prepareStatement ("SELECT* FROM addquestion WHERE CATEGORY='"+CATEGORY.getText()+"' and ID = "+CURRENTQID);
            rs=str.executeQuery();
            if (rs.next()){
                
                question.setText(rs.getString("QUESTION"));
                A.setText(rs.getString("a"));
                B.setText(rs.getString("b"));
                C.setText(rs.getString("c"));
                ANSWER=rs.getString("ANSWER");
                int id=Integer.parseInt(QNO.getText());
                id++;
                QNO.setText(""+id);
            }
         }catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
         }
    }
    
    
    
    
    
    
    public void getbackQuestion(){
        if (CHECK[index]==1){
            markes--;
        }
        int id=Integer.parseInt(QNO.getText());
        id--;
        QNO.setText(""+id);
        int CURRENTQID=QIDs.get(index);
        try {
            str=con.prepareStatement ("SELECT* FROM addquestion WHERE ID = "+CURRENTQID);
            rs=str.executeQuery();
            if (rs.next()){
                
                question.setText(rs.getString("QUESTION"));
                A.setText(rs.getString("a"));
                B.setText(rs.getString("b"));
                C.setText(rs.getString("c"));
                ANSWER=rs.getString("ANSWER");
                
                
                
            }
         }catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
         }
    }
    
    
    
    
    
    
    
    public void checkans(){
        if(A.isSelected()){
            if(A.getText().equals(ANSWER)){
                markes++;
                CHECK[index-1]=1;
            }
            getQuestion();
        }else if(B.isSelected()){
             if(B.getText().equals(ANSWER)){
                markes++;
                CHECK[index-1]=1;
            }
             getQuestion();
        }else if (C.isSelected()){
             if(C.getText().equals(ANSWER)){
                markes++;
                CHECK[index-1]=1;
             }
             getQuestion();
        }else {
            JOptionPane.showMessageDialog(this, "OPTION NOT SELECTED");
                  
        }
        buttonGroup1.clearSelection();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void SUBMITCHECK(){
        
        int min = Integer.parseInt(MIN.getText());
        int sec = Integer.parseInt(SEC.getText());
        String id = ID.getText();
        String name = NAME.getText();
        String category = CATEGORY.getText();
        
       
        
        if(A.isSelected()){
            if(A.getText().equals(ANSWER)){
                markes++;
                
            }
           
        } 
        if(B.isSelected()){
            if(B.getText().equals(ANSWER)){
                markes++;
               
            }
         
        }
        if (C.isSelected()){
            if(C.getText().equals(ANSWER)){
                markes++;
                
            }
           
        }
        submit(min, sec, id, name, category, markes);
        buttonGroup1.clearSelection();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void submit(int min,int sec,String id,String name,String categ,int mark){
            jButton4.hide();
            try{
                        
                        int m=10-min;
                        int s=60-sec;
                        str=con.prepareStatement("INSERT INTO `result`(`ID`, `NAME`, `CATEGORY`, `marks`, `timetaken` ) VALUES(?,?,?,?,?)");
                        str.setString(1, id);
                        str.setString(2, name);
                        str.setString(3, categ);
                        str.setInt(4, mark);
                        str.setString(5, m+" min : "+s+" sec");
                        str.executeUpdate();
                        if (mark>=7){
                            JOptionPane.showMessageDialog(this, "<html><b style=\"color:green; font-size:24px;\">OBTAND MARKES="+mark+"\t\t(GOOD (A+) 😍)"+"</b></html>.","SUCCESS",1);
                        } else if (mark>=5){
                            JOptionPane.showMessageDialog(this, "<html><b style=\"color:yellow;  font-size:24px;\">OBTAND MARKES="+mark+"\t\t(NEED TO STUDY (B) 😐)"+"</b></html>.","PASS",1);  
                        }else{
                            JOptionPane.showMessageDialog(this, "<html><b style=\"color:red;  font-size:24px;\">OBTAND MARKES="+mark+"\t\t(FAILED 😡)"+"</b></html>.","FAIL",1);  
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,e,"DATABASE ERROR",3);
                    }
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CATEGORY = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MIN = new javax.swing.JLabel();
        QNO = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SEC = new javax.swing.JLabel();
        MIN1 = new javax.swing.JLabel();
        MIN2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        question = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        A = new javax.swing.JRadioButton();
        B = new javax.swing.JRadioButton();
        C = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDesktopPane1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 220));

        jPanel2.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 220));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setText("ID#             :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 150, 50));

        ID.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel2.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 250, 50));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setText("NAME          :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, 60));

        NAME.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel2.add(NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 400, 50));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setText("CATEGORY  :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 150, 40));

        CATEGORY.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel2.add(CATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 380, 50));

        DATE.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        DATE.setText("DATE");
        jPanel2.add(DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 160, 40));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("DATE     :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 90, 40));

        MIN.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        MIN.setText("0");
        jPanel2.add(MIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 40, 40));

        QNO.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        QNO.setText("0");
        jPanel2.add(QNO, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 90, 30));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel7.setText("TIME      :    10min");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 180, 40));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel9.setText("Q #       :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 90, -1));

        SEC.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        SEC.setText("0");
        jPanel2.add(SEC, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 50, 40));

        MIN1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        MIN1.setText("SEC");
        jPanel2.add(MIN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 150, 30, 40));

        MIN2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        MIN2.setText("MIN :");
        jPanel2.add(MIN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 50, 40));

        jButton1.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-close-36.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 60, 40));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        question.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        question.setText("QUESTIOn");
        jPanel3.add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel6.setText("Q");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 40));

        buttonGroup1.add(A);
        A.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed1(evt);
            }
        });
        jPanel3.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 440, 50));

        buttonGroup1.add(B);
        B.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        B.setText("B");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        jPanel3.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 440, 50));

        buttonGroup1.add(C);
        C.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        jPanel3.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 440, 50));

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel8.setText("C)");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 20, -1));

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel11.setText("A)");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 20, -1));

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel12.setText("B)");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 30, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-double-right-100.png"))); // NOI18N
        jButton2.setText("NEXT");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 210, 90));

        jButton3.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/icons8-enter-100.png"))); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 250, 90));

        jButton4.setBackground(new java.awt.Color(0, 0, 0,0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/icons8-double-left-100.png"))); // NOI18N
        jButton4.setText("BACK");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, 90));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1320, 410));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FILES/pics/quiz.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 410, 310));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel10.setText("GOOD LUCK");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:     * WARNING: Do NOT modify this code. The content of this method is always
        studentmain.Kye=0;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (index>=10 ||index<0  ){
            
            
            JOptionPane.showMessageDialog(this, "ERROR IN NEXT BUTTON");
            
            
        }else {
            
            
            if (!buttonGroup1.isSelected(null)){
                
                index++;
                checkans();
            }else{
                JOptionPane.showMessageDialog(this, "OPTION MUST BE SELECTED","ERROR",2);
            }
            
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        timer.stop();
        if (buttonGroup1.getSelection()==null){
            JOptionPane.showMessageDialog(this, "OPTION NOT SELECTED");
            return;      
        }
        SUBMITCHECK();
        question.setText("NONE");
        A.setText("NONE");
        B.setText("NONE");
        C.setText("NONE");
        jButton3.hide();
        jButton1.show();
        for (int i=0;i<10;i++){
            System.out.println(CHECK[i]);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int Qn =Integer.parseInt(QNO.getText());
        if (index<=0 || Qn<=1 ){
            JOptionPane.showMessageDialog(this, "FIRST QUESTION");
        }else if (Qn>1 && Qn<=10 && index>0){
            index--;
            getbackQuestion();
            
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AActionPerformed

    private void AActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed1
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_AActionPerformed1

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
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUIZ().setVisible(true);
            }

        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton A;
    private javax.swing.JRadioButton B;
    private javax.swing.JRadioButton C;
    private javax.swing.JLabel CATEGORY;
    private javax.swing.JLabel DATE;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel MIN;
    private javax.swing.JLabel MIN1;
    private javax.swing.JLabel MIN2;
    private javax.swing.JLabel NAME;
    private javax.swing.JLabel QNO;
    private javax.swing.JLabel SEC;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
