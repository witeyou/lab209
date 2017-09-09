/**
 * Created by Administrator on 2017/8/15.
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class LibraryloginText {
    public static void main(String[] args)
    {
// TODO Auto-generated method stub

        EventQueue.invokeLater(new Runnable(){
            public void run()
            {
                LibraryloginFrame frame = new LibraryloginFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
