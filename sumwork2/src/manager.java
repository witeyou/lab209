import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Hashtable;
public class manager extends JFrame implements ActionListener{
	 tianjia    �������=null;          
     update  �����޸�=null;          
     find    ��ȷ��ѯ=null; 
     ztcx  �����ѯ=null; 
     mhcx  ģ����ѯ=null;
     about ����=null;
     JButton ���,�޸�,��ȷ��ѯ1,�����ѯ1,ģ����ѯ1,bbbb;     
   Container con=null;
                           
   CardLayout card=null;                       
   JLabel label=null;                          
   JPanel pCenter;
   JPanel aa,bb;
   public manager(){
   
     JPanel aa=new JPanel();
      JPanel bb=new JPanel();
     aa.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
     ���=new JButton("��Ӻ���");
     �޸�=new JButton("�޸ĺ���");
     ��ȷ��ѯ1=new JButton("��ȷ��ѯ");
     �����ѯ1=new JButton("�����ѯ");
     ģ����ѯ1=new JButton("ģ����ѯ");
     bbbb=new JButton("����");
     aa.add(���);
     aa.add(�޸�);
     aa.add(��ȷ��ѯ1);
     aa.add(�����ѯ1);
     aa.add(ģ����ѯ1);
     bb.add(bbbb);
     label=new JLabel("��ӭʹ�õ绰�������ϵͳ",JLabel.CENTER);
     label.setFont(new Font("TimesRoman",Font.BOLD,24));
     label.setForeground(Color.red);
     ���.addActionListener(this);
     �޸�.addActionListener(this);
     ��ȷ��ѯ1.addActionListener(this);
     �����ѯ1.addActionListener(this);
     ģ����ѯ1.addActionListener(this);
     bbbb.addActionListener(this);
     card=new CardLayout();
     con=getContentPane();
     pCenter=new JPanel();
     pCenter.setLayout(card); 
    
      �������=new tianjia();
     �����޸�=new update();
     ��ȷ��ѯ=new find(this);
     �����ѯ=new ztcx();
     ģ����ѯ=new mhcx();
      ����=new about(this);
     pCenter.add("��ӭ�����",label);
     pCenter.add("¼�����",�������);
     pCenter.add("�޸Ľ���",�����޸�);    
     pCenter.add("�����ѯ����",�����ѯ);
     pCenter.add("ģ����ѯ����",ģ����ѯ);
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
     if(e.getSource()==���)
       {
         card.show(pCenter,"¼�����");
       }
     else if(e.getSource()==�޸�)
       {
         card.show(pCenter,"�޸Ľ���");
       }
     else if(e.getSource()==��ȷ��ѯ1)
      {
         ��ȷ��ѯ.setVisible(true);
      }
     else if(e.getSource()==�����ѯ1)
      {
         card.show(pCenter,"�����ѯ����");
      }
      else if(e.getSource()==ģ����ѯ1)
      {
         card.show(pCenter,"ģ����ѯ����");
      }
      else if(e.getSource()==bbbb){
         ����.setVisible(true);
      }
   }
  public static void main(String args[])
   {
     new manager();
   }
      
   
}