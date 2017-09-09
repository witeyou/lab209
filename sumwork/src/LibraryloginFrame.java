/**
 * Created by Administrator on 2017/8/15.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class LibraryloginFrame extends JFrame{

    public LibraryloginFrame()
    {
        setTitle("图书管理系统-登陆"); //设置标题
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);//设置大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension  screenSize =kit.getScreenSize();
        double WIDTH=screenSize.getWidth();
        double HEIGHT =screenSize.getHeight();
        this.setBounds((int)WIDTH/2,(int)HEIGHT/2,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        Image ima = kit.getImage("book.jpg");//设置图标
        setIconImage(ima);
//设置观感
        String plaf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

        try {
            UIManager.setLookAndFeel(plaf);
        } catch (ClassNotFoundException e2) {

            e2.printStackTrace();
        } catch (InstantiationException e2) {


            e2.printStackTrace();
        } catch (IllegalAccessException e2) {

            e2.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }//存在问题待解决
        /*catch (UnsupportedLookAndFeelException e2)
        {
            e2.printStackTrace();
        }
        */
        SwingUtilities.updateComponentTreeUI(this);
        File file = new File("password.txt");//打开保存的密码
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bf = new BufferedReader(reader);

            try {

                password2 = bf.readLine();

            } catch (IOException e1) {

                e1.printStackTrace();
            }
            reader.close();
            bf.close();
        } catch (FileNotFoundException e1) {

            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        JLabel left1 = new JLabel("User name:",SwingConstants.CENTER);
        JLabel left2 = new JLabel("Password:",SwingConstants.CENTER);
        northPanel.add(left1);
        northPanel.add(textField);
        northPanel.add(left2);

        northPanel.add(passwordField);

        BorderLayout bl = new BorderLayout();

        this.setLayout(bl);

        add(northPanel,BorderLayout.NORTH);

        field = new JTextField(30);

        this.add(field,BorderLayout.CENTER);

        JPanel southPanel = new JPanel();

        add(southPanel,BorderLayout.SOUTH);



        JButton button = new JButton("确定");

        southPanel.add(button);

        button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)

            {



                text= textField.getText().trim();

                password1 = new String(passwordField.getPassword());

                result =text+password1;

                if(result.equals(password2))//验证用户名和密码

                {

                    field.setText("恭喜你，登陆成功!!")  ;



                }else {

                    field.setText("对不起，账号或密码错误，请重新输入!!")  ;

                    textField.setText("");

                    passwordField.setText("");

                }







            }});

    }



    private static final int DEFAULT_WIDTH = 300;

    private static final int DEFAULT_HEIGHT =200;

    private JTextField field;//显示登陆结果

    private String text;//放用户名

    private String password1;//放登陆密码

    private String result;//放用户名+密码

    private String password2;//放从密码文件里读取的密码



}