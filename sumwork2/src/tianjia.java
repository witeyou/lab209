import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class tianjia extends JPanel implements ActionListener{

	JTextField 姓名,手机号码,家庭电话,办公电话;
	JButton 确定,重置;

  public tianjia(){

  	姓名=new JTextField(15);
  	手机号码=new JTextField(15);
  	家庭电话=new JTextField(15);
  	办公电话=new JTextField(15);
  	确定=new JButton("确定");
    重置=new JButton("重置");
    确定.addActionListener(this);
    重置.addActionListener(this);
    Box box1=Box.createHorizontalBox();
    box1.add(new JLabel("姓     名:",JLabel.CENTER));
   box1.add(姓名);
   Box box2=Box.createHorizontalBox();              
   box2.add(new JLabel("手机号码:",JLabel.CENTER));
   box2.add(手机号码);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("家庭电话:",JLabel.CENTER));
   box3.add(家庭电话);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("办公电话:",JLabel.CENTER));
   box4.add(办公电话);
   Box boxH=Box.createVerticalBox();              
   boxH.add(box1);
   boxH.add(box2);
   boxH.add(box3);
   boxH.add(box4);
   boxH.add(Box.createVerticalGlue());          
   JPanel pCenter=new JPanel();
   pCenter.add(boxH);
   setLayout(new BorderLayout());
   add(pCenter,BorderLayout.CENTER);
   JPanel pSouth=new JPanel();
   pSouth.add(确定);
   pSouth.add(重置);
   add(pSouth,BorderLayout.SOUTH);
   validate();
   
  }
  public void actionPerformed(ActionEvent e){
  	 String name="";
     String url="jdbc:odbc:diaoyou1";     
     String s1="";
     String s2="";
     String s3="";
     String s4="";
  	 try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }catch(java.lang.ClassNotFoundException eee){}
     s1=姓名.getText();
     s2=手机号码.getText();
     s3=家庭电话.getText();
     s4=办公电话.getText();
     String sql="insert into number values(?,?,?,?)";
     if(e.getSource()==确定){
     	
     	
     	if(s1==""){String warning="必须输入姓名!";
                    
                   JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);
     		}
     	else{
     		    String m="添加此人电话!";
                   int ok=JOptionPane.showConfirmDialog(this,m,"确认",JOptionPane.YES_NO_OPTION,
                                                 JOptionPane.INFORMATION_MESSAGE);
             if(ok==JOptionPane.YES_OPTION){
             	try{
             	Connection con=DriverManager.getConnection(url,"",null);
        	    Statement stmt=con.createStatement();
        	    PreparedStatement ps=con.prepareStatement(sql);
        	    ps.setString(1,s1);
        	    ps.setString(2,s2);
        	    ps.setString(3,s3);
        	    ps.setString(4,s4);
        	    ps.executeUpdate();
        	    stmt.close();
        	    con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
             }      
     	
     		}
     		姓名.setText(null);
        手机号码.setText(null);
        家庭电话.setText(null);
        办公电话.setText(null);
     }

      if(e.getSource()==重置)
      { 
        姓名.setText(null);
        手机号码.setText(null);
        家庭电话.setText(null);
        办公电话.setText(null);
        } 
  }
  /*public void textValueChanged(TextEvent e){
  	if(e.getSource()==手机号码||e.getSource()==家庭电话||e.getSource()==办公电话){
  		String s=手机号码.getText();
					for(int i=0;i<s.length();i++){
						char c=s.charAt(i);
						if(c<'0'||c>'9'){
							String warning="号码只能为数字!";
              JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);
						}
  	}*/
  }
  
