import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class tianjia extends JPanel implements ActionListener{

	JTextField ����,�ֻ�����,��ͥ�绰,�칫�绰;
	JButton ȷ��,����;

  public tianjia(){

  	����=new JTextField(15);
  	�ֻ�����=new JTextField(15);
  	��ͥ�绰=new JTextField(15);
  	�칫�绰=new JTextField(15);
  	ȷ��=new JButton("ȷ��");
    ����=new JButton("����");
    ȷ��.addActionListener(this);
    ����.addActionListener(this);
    Box box1=Box.createHorizontalBox();
    box1.add(new JLabel("��     ��:",JLabel.CENTER));
   box1.add(����);
   Box box2=Box.createHorizontalBox();              
   box2.add(new JLabel("�ֻ�����:",JLabel.CENTER));
   box2.add(�ֻ�����);
   Box box3=Box.createHorizontalBox();              
   box3.add(new JLabel("��ͥ�绰:",JLabel.CENTER));
   box3.add(��ͥ�绰);
   Box box4=Box.createHorizontalBox();              
   box4.add(new JLabel("�칫�绰:",JLabel.CENTER));
   box4.add(�칫�绰);
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
   pSouth.add(ȷ��);
   pSouth.add(����);
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
     s1=����.getText();
     s2=�ֻ�����.getText();
     s3=��ͥ�绰.getText();
     s4=�칫�绰.getText();
     String sql="insert into number values(?,?,?,?)";
     if(e.getSource()==ȷ��){
     	
     	
     	if(s1==""){String warning="������������!";
                    
                   JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);
     		}
     	else{
     		    String m="��Ӵ��˵绰!";
                   int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,
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
     		����.setText(null);
        �ֻ�����.setText(null);
        ��ͥ�绰.setText(null);
        �칫�绰.setText(null);
     }

      if(e.getSource()==����)
      { 
        ����.setText(null);
        �ֻ�����.setText(null);
        ��ͥ�绰.setText(null);
        �칫�绰.setText(null);
        } 
  }
  /*public void textValueChanged(TextEvent e){
  	if(e.getSource()==�ֻ�����||e.getSource()==��ͥ�绰||e.getSource()==�칫�绰){
  		String s=�ֻ�����.getText();
					for(int i=0;i<s.length();i++){
						char c=s.charAt(i);
						if(c<'0'||c>'9'){
							String warning="����ֻ��Ϊ����!";
              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);
						}
  	}*/
  }
  
