import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class about extends JDialog{
   JLabel a,b,c;
   public about(JFrame f){
   	super(f,"关于",false);
   	a=new JLabel("JAVA 通讯录");
   	b=new JLabel("计嵌162 史学超");
   	c=new JLabel("暑期试手");
   	a.setForeground(Color.red);
   	a.setFont(new Font("TimesRoman",Font.BOLD,16));
   	b.setForeground(Color.red);
   	b.setFont(new Font("TimesRoman",Font.BOLD,16));
   	c.setForeground(Color.red);
   	c.setFont(new Font("TimesRoman",Font.BOLD,16));
   	Box box1=Box.createHorizontalBox();
   	box1.add(a);
   	Box box2=Box.createHorizontalBox();
    box2.add(b);
    Box box3=Box.createHorizontalBox();
    box3.add(c);
    Box boxH=Box.createVerticalBox();
    boxH.add(a);
    boxH.add(b);
    boxH.add(c);
    boxH.add(Box.createVerticalGlue());
    JPanel pCenter=new JPanel();
   pCenter.add(boxH);
   Container con=getContentPane();
   con.add(pCenter,BorderLayout.CENTER);
   con.validate();
   setVisible(false);
   setBounds(100,150,200,150);
    addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                         setVisible(false);
      	               }
                    });
   
   }
}