import java.sql.*;
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class update extends JPanel implements ActionListener{
	JTextField 姓名,手机号码,家庭电话,办公电话;
	JButton 开始修改,录入修改,重置;
  public update(){  
  	姓名=new JTextField(15);
  	手机号码=new JTextField(15);
  	家庭电话=new JTextField(15);
  	办公电话=new JTextField(15);
  	开始修改=new JButton("开始修改");
   录入修改=new JButton("录入修改");
   录入修改.setEnabled(false);
   重置=new JButton("重置");
   姓名.addActionListener(this);
   开始修改.addActionListener(this);
   录入修改.addActionListener(this);
   重置.addActionListener(this);
    Box box1=Box.createHorizontalBox();              
   box1.add(new JLabel("输入要修改信息的姓名:",JLabel.CENTER));
   box1.add(姓名);
   box1.add(开始修改);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("(新)手机号码:",JLabel.CENTER));
   box3.add(手机号码);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("(新)家庭电话:",JLabel.CENTER));
   box4.add(家庭电话);
   Box box5=Box.createHorizontalBox();              
   box5.add(new JLabel("(新)办公电话:",JLabel.CENTER));
   box5.add(办公电话);
   Box boxH=Box.createVerticalBox();              
   boxH.add(box1);
   boxH.add(box3);
   boxH.add(box4);
   boxH.add(box5);
   boxH.add(Box.createVerticalGlue());           
   JPanel pCenter=new JPanel();
   pCenter.add(boxH);
   setLayout(new BorderLayout());
   add(pCenter,BorderLayout.CENTER);
   JPanel pSouth=new JPanel();
   pSouth.add(录入修改);
   pSouth.add(重置);
   add(pSouth,BorderLayout.SOUTH);
   validate();
  }
  public void actionPerformed(ActionEvent e){
  	 String name="";
     String s1="";
     String s2="";
     String s3="";
     String s4="";
     String url="jdbc:odbc:diaoyou1";
     
     
  	 try{
         	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }catch(java.lang.ClassNotFoundException eee){}
      
      if(e.getSource()==开始修改){
      	name=姓名.getText();
      	String sql="select * from number where 姓名='"+name+"'";
        
      	try{
        	Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	ResultSet rs=stmt.executeQuery(sql);
        	while(rs.next()){
        	 s1=rs.getString("姓名");
        	 s2=rs.getString("手机号码");
        	 s3=rs.getString("家庭电话");
        	 s4=rs.getString("办公电话");
        	}
        	stmt.close();
        	con.close();
        	}catch(SQLException ex){System.out.println(ex.getMessage());}
        if(s1!=null){
        	录入修改.setEnabled(true);
        
        	手机号码.setText(s2);
        	家庭电话.setText(s3);
        	办公电话.setText(s4);
        	
        }
      }  
      if(e.getSource()==录入修改){
      	name=姓名.getText();
      	s2=手机号码.getText();
      	s3=家庭电话.getText();
      	s4=办公电话.getText();    
      	String sql2="update number set 手机号码='"+s2+"'"+" where 姓名='"+name+"'";
        String sql3="update number set 家庭电话='"+s3+"'"+" where 姓名='"+name+"'";
        String sql4="update number set 办公电话='"+s4+"'"+" where 姓名='"+name+"'";
      	try{
        	Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	stmt.executeUpdate(sql2);
        	stmt.executeUpdate(sql3);
        	stmt.executeUpdate(sql4);
        	stmt.close();
        	con.close();
        	}catch(SQLException exx){System.out.println(exx.getMessage());}
     
        } 
  	
   if(e.getSource()==重置)
      { 
        姓名.setText(null);                                
                  手机号码.setText(null);
                  家庭电话.setText(null);
                  办公电话.setText(null);
      }
  }
}