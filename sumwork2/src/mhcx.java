import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class mhcx extends JPanel implements ActionListener{
     JTextArea ruslt;
     JTextField tj;
	 JButton 查询;
	 String name;
	 String sql="";
	 JLabel p;
	 public mhcx(){
	 	ruslt=new JTextArea(10,28);
	 	ruslt.setEditable(false);
	 	查询=new JButton("查询");
        tj=new JTextField(5);
        p=new JLabel("请输入条件:");
	 	Box box2=Box.createHorizontalBox();
	 	box2.add(p);
	 	box2.add(tj);
	 	box2.add(查询);
	 	Box box3=Box.createHorizontalBox();
	 	box3.add(ruslt);
	 	Box boxH=Box.createVerticalBox(); 
        boxH.add(box2);
        boxH.add(box3);
        查询.addActionListener(this);
        JPanel pCenter=new JPanel();
        pCenter.add(boxH);
        setLayout(new BorderLayout());
        add(pCenter,BorderLayout.CENTER);
        validate();
	 }
	 
	 public void actionPerformed(ActionEvent e){
	 	String url="jdbc:mysql://localhost/diaoyou1?user=root&password=";//第一次调用
		 // String url="jdbc:odbc:diaoyou1";
        String s1="";
        String s2="";
        String s3="";
        String s4="";
        try{
        	Class.forName("com.mysql.jdbc.Driver");//
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         }catch(java.lang.ClassNotFoundException eee){}
	 	if(e.getSource()==查询){
	 		try{
        	Connection con=DriverManager.getConnection(url);
        	//Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	name=tj.getText();
        	sql="select * from number where 姓名 like '%"+name+"%'";
        	
        	ResultSet rs=stmt.executeQuery(sql); 
        	ruslt.setText("姓  名          手机号码           家庭电话           办公电话\n");
        	if(!rs.next())
        	      ruslt.setText("无记录");
        	   else     	
        	{
        		do{
        			s1=rs.getString("姓名");
        			s2=rs.getString("手机号码");
        	        s3=rs.getString("家庭电话");
        	        s4=rs.getString("办公电话");
        		    ruslt.append(s1);
        		    ruslt.append(s2);
        		    ruslt.append(s3);
        		    ruslt.append(s4+"\n");
        		}while(rs.next());
        	}
        	
        	stmt.close();
        	con.close();
        	
        	}catch(SQLException ex){System.out.println(ex.getMessage());}
	 	}
	 }

         
  }