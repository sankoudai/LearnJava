import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;

public class TestSimpleAnimation2 {
    // JFrame frame;
    int x=30;
    int y = 30 ;

    public static void main(String[] args) {
        TestSimpleAnimation2 gui = new TestSimpleAnimation2();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i=30; i<300 ; i++ ) {
            x++;
            y++;
            drawPanel.repaint();

            try{
                Thread.sleep(10);
            }catch(Exception ex){}
        }
    }


    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g){
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

           int red = (int) (Math.random()*255);
           int green = (int) (Math.random()*255);
           int blue = (int) (Math.random()*255);

            Color color = new Color(red, green, blue);
            g.setColor(Color.red);
            // System.out.print(x);

            g.fillOval(x, y, 40, 40);
            // g.fillOval(x, y, 30, 30);
        }
    }
}

