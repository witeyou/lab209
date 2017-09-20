import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
public class find extends JDialog implements ActionListener{
	
	JTextField 姓名,手机号码,家庭电话,办公电话;
	JButton 查询,删除;
          
  public find(JFrame f){
  	super(f,"查询对话框",false);                           
   姓名=new JTextField(15);
   查询=new JButton("查询");
   删除=new JButton("删除");
   查询.addActionListener(this);
   删除.addActionListener(this);
   姓名=new JTextField(15);
   手机号码=new JTextField(15);
   手机号码.setEditable(false);
   家庭电话=new JTextField(15);
   家庭电话.setEditable(false);
   办公电话=new JTextField(15);
   办公电话.setEditable(false);
   Box box1=Box.createHorizontalBox();
   box1.add(new JLabel("输入要查询的姓名:",JLabel.CENTER));
   box1.add(姓名);
   box1.add(查询);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("手机号码:",JLabel.CENTER));
   box3.add(手机号码);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("家庭电话:",JLabel.CENTER));
   box4.add(家庭电话);
   Box box5=Box.createHorizontalBox();              
   box5.add(new JLabel("办公电话:",JLabel.CENTER));
   box5.add(办公电话);
   Box box6=Box.createHorizontalBox(); 
   box6.add(删除);
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
     //String url="jdbc:odbc:diaoyou1";
      String url="jdbc:mysql://localhost/diaoyou1?user=root&password=";//第一次测试
     String s1="";
     String s2="";
     String s3="";
     String s4="";
    if(e.getSource()==查询)
    {
        try
        {
         	Class.forName("com.mysql.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException eee){}
        name=姓名.getText();
        String sql="select * from number where 姓名='"+name+"'";
        if(name!="")
        {
            try
            {
                Connection con=DriverManager.getConnection(url);
        	    Statement stmt=con.createStatement();
        	    ResultSet rs=stmt.executeQuery(sql);
        	    while(rs.next())
                {
        	        s1=rs.getString("姓名");
        	        s2=rs.getString("手机号码");
        	        s3=rs.getString("家庭电话");
        	        s4=rs.getString("办公电话");
                }
        	stmt.close();
        	con.close();
        	}
        	catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        	if(s1!=null)
        	{
        		姓名.setText(s1);
                手机号码.setText(s2);
                家庭电话.setText(s3);
                办公电话.setText(s4); 
        	}                      
        }
    }
    if(e.getSource()==删除)
     {
     	try
        {
         	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException eee){}
        name=姓名.getText();
        String sql="delete from number where 姓名='"+name+"'";
        try
        {
        	Connection con=DriverManager.getConnection(url,"",null);
        	Statement stmt=con.createStatement();
        	stmt.executeUpdate(sql);
        	stmt.close();
        	con.close();
        }
        catch(SQLException eex){System.out.println(eex.getMessage());}
        姓名.setText(null);
        手机号码.setText(null);
        家庭电话.setText(null);
        办公电话.setText(null);
     }
  }
}