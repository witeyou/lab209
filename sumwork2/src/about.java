import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class about extends JDialog{
   JLabel a,b,c;
   public about(JFrame f){
   	super(f,"����",false);
   	a=new JLabel("�绰�������ϵͳ  V 1.0");
   	b=new JLabel("��д:05��ý��2��  �� ��");
   	c=new JLabel("��Ȩ����       ��Ȩ�ؾ�");
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