import java.sql.*;
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class update extends JPanel implements ActionListener{
	JTextField ����,�ֻ�����,��ͥ�绰,�칫�绰;
	JButton ��ʼ�޸�,¼���޸�,����;
  public update(){  
  	����=new JTextField(15);
  	�ֻ�����=new JTextField(15);
  	��ͥ�绰=new JTextField(15);
  	�칫�绰=new JTextField(15);
  	��ʼ�޸�=new JButton("��ʼ�޸�");
   ¼���޸�=new JButton("¼���޸�");
   ¼���޸�.setEnabled(false);
   ����=new JButton("����");
   ����.addActionListener(this);
   ��ʼ�޸�.addActionListener(this);
   ¼���޸�.addActionListener(this);
   ����.addActionListener(this);
    Box box1=Box.createHorizontalBox();              
   box1.add(new JLabel("����Ҫ�޸���Ϣ������:",JLabel.CENTER));
   box1.add(����);
   box1.add(��ʼ�޸�);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("(��)�ֻ�����:",JLabel.CENTER));
   box3.add(�ֻ�����);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("(��)��ͥ�绰:",JLabel.CENTER));
   box4.add(��ͥ�绰);
   Box box5=Box.createHorizontalBox();              
   box5.add(new JLabel("(��)�칫�绰:",JLabel.CENTER));
   box5.add(�칫�绰);
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
   pSouth.add(¼���޸�);
   pSouth.add(����);
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
      
      if(e.getSource()==��ʼ�޸�){
      	name=����.getText();
      	String sql="select * from number where ����='"+name+"'";
        
      	try{
        	Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	ResultSet rs=stmt.executeQuery(sql);
        	while(rs.next()){
        	 s1=rs.getString("����");
        	 s2=rs.getString("�ֻ�����");
        	 s3=rs.getString("��ͥ�绰");
        	 s4=rs.getString("�칫�绰");
        	}
        	stmt.close();
        	con.close();
        	}catch(SQLException ex){System.out.println(ex.getMessage());}
        if(s1!=null){
        	¼���޸�.setEnabled(true);
        
        	�ֻ�����.setText(s2);
        	��ͥ�绰.setText(s3);
        	�칫�绰.setText(s4);
        	
        }
      }  
      if(e.getSource()==¼���޸�){
      	name=����.getText();
      	s2=�ֻ�����.getText();
      	s3=��ͥ�绰.getText();
      	s4=�칫�绰.getText();    
      	String sql2="update number set �ֻ�����='"+s2+"'"+" where ����='"+name+"'";
        String sql3="update number set ��ͥ�绰='"+s3+"'"+" where ����='"+name+"'";
        String sql4="update number set �칫�绰='"+s4+"'"+" where ����='"+name+"'";
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
  	
   if(e.getSource()==����)
      { 
        ����.setText(null);                                
                  �ֻ�����.setText(null);
                  ��ͥ�绰.setText(null);
                  �칫�绰.setText(null);
      }
  }
}