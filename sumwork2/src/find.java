import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class find extends JDialog implements ActionListener{
	
	JTextField ����,�ֻ�����,��ͥ�绰,�칫�绰;
	JButton ��ѯ,ɾ��;
          
  public find(JFrame f){
  	super(f,"��ѯ�Ի���",false);                           
   ����=new JTextField(15);
   ��ѯ=new JButton("��ѯ");
   ɾ��=new JButton("ɾ��");
   ��ѯ.addActionListener(this);
   ɾ��.addActionListener(this);
   ����=new JTextField(15);
   �ֻ�����=new JTextField(15);
   �ֻ�����.setEditable(false);
   ��ͥ�绰=new JTextField(15);
   ��ͥ�绰.setEditable(false);
   �칫�绰=new JTextField(15);
   �칫�绰.setEditable(false);
   Box box1=Box.createHorizontalBox();
   box1.add(new JLabel("����Ҫ��ѯ������:",JLabel.CENTER));
   box1.add(����);
   box1.add(��ѯ);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("�ֻ�����:",JLabel.CENTER));
   box3.add(�ֻ�����);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("��ͥ�绰:",JLabel.CENTER));
   box4.add(��ͥ�绰);
   Box box5=Box.createHorizontalBox();              
   box5.add(new JLabel("�칫�绰:",JLabel.CENTER));
   box5.add(�칫�绰);
   Box box6=Box.createHorizontalBox(); 
   box6.add(ɾ��);
   Box boxH=Box.createVerticalBox();              
   boxH.add(box1);
   boxH.add(box3);
   boxH.add(box4);
   boxH.add(box5);
   boxH.add(box6);
   boxH.add(Box.createVerticalGlue());          
   JPanel pCenter=new JPanel();
   pCenter.add(boxH);
   Container con=getContentPane();
   con.add(pCenter,BorderLayout.CENTER);
   con.validate();
   setVisible(false);
   setBounds(100,200,360,270);
    addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                         setVisible(false);
      	               }
                    });
                   
  }
   public void actionPerformed(ActionEvent e)
  {    
     String name="";
     String url="jdbc:odbc:diaoyou1";
     
     String s1="";
     String s2="";
     String s3="";
     String s4="";
    if(e.getSource()==��ѯ)
      {
         try{
         	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }catch(java.lang.ClassNotFoundException eee){}
         name=����.getText();
         String sql="select * from number where ����='"+name+"'";
         if(name!=""){
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
        		����.setText(s1);
                �ֻ�����.setText(s2);
                ��ͥ�绰.setText(s3);
                �칫�绰.setText(s4); 
        	}                      
            }        
      } 
     if(e.getSource()==ɾ��) {
     	try{
         	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }catch(java.lang.ClassNotFoundException eee){}
         name=����.getText();
         String sql="delete from number where ����='"+name+"'";
         try{
        	Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	stmt.executeUpdate(sql);
        	stmt.close();
        	con.close();
        	}catch(SQLException eex){System.out.println(eex.getMessage());}
        	����.setText(null);
                �ֻ�����.setText(null);
                ��ͥ�绰.setText(null);
                �칫�绰.setText(null);
     }
  }
}