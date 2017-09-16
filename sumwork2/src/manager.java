import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Hashtable;
public class manager extends JFrame implements ActionListener{
	 tianjia    号码添加=null;          
     update  号码修改=null;          
     find    精确查询=null; 
     ztcx  整体查询=null; 
     mhcx  模糊查询=null;
     about 关于=null;
     JButton 添加,修改,精确查询1,整体查询1,模糊查询1,bbbb;     
   Container con=null;
                           
   CardLayout card=null;                       
   JLabel label=null;                          
   JPanel pCenter;
   //JPanel aa,bb;
   public manager(){

    JPanel aa=new JPanel();
    JPanel bb=new JPanel();
     aa.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
     添加=new JButton("添加号码");
     修改=new JButton("修改号码");
     精确查询1=new JButton("精确查询");
     整体查询1=new JButton("整体查询");
     模糊查询1=new JButton("模糊查询");
     bbbb=new JButton("关于");
     aa.add(添加);
     aa.add(修改);
     aa.add(精确查询1);
     aa.add(整体查询1);
     aa.add(模糊查询1);
     bb.add(bbbb);
     label=new JLabel("欢迎使用电话号码管理系统",JLabel.CENTER);
     label.setFont(new Font("TimesRoman",Font.BOLD,24));
     label.setForeground(Color.red);
     添加.addActionListener(this);
     修改.addActionListener(this);
     精确查询1.addActionListener(this);
     整体查询1.addActionListener(this);
     模糊查询1.addActionListener(this);
     bbbb.addActionListener(this);
     card=new CardLayout();
     con=getContentPane();
     pCenter=new JPanel();
     pCenter.setLayout(card); 
    
      号码添加=new tianjia();
     号码修改=new update();
     精确查询=new find(this);
     整体查询=new ztcx();
     模糊查询=new mhcx();
      关于=new about(this);
     pCenter.add("欢迎语界面",label);
     pCenter.add("录入界面",号码添加);
     pCenter.add("修改界面",号码修改);    
     pCenter.add("整体查询界面",整体查询);
     pCenter.add("模糊查询界面",模糊查询);
     con.add(aa,BorderLayout.NORTH);
     con.add(bb,BorderLayout.SOUTH);
     con.add(pCenter,BorderLayout.CENTER);
     con.validate();
     addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                          System.exit(0);
      	               }
                    });
    setVisible(true);
    setBounds(100,50,520,380);
    validate();
   }
   public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==添加)
       {
         card.show(pCenter,"录入界面");
       }
     else if(e.getSource()==修改)
       {
         card.show(pCenter,"修改界面");
       }
     else if(e.getSource()==精确查询1)
      {
         精确查询.setVisible(true);
      }
     else if(e.getSource()==整体查询1)
      {
         card.show(pCenter,"整体查询界面");
      }
      else if(e.getSource()==模糊查询1)
      {
         card.show(pCenter,"模糊查询界面");
      }
      else if(e.getSource()==bbbb){
         关于.setVisible(true);
      }
   }
  public static void main(String args[])
   {
     new manager();
   }
      
   
}