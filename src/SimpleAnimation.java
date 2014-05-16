import javax.swing.*;
import java.awt.* ;


public class SimpleAnimation {

    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();

    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i<130; i++) {
            // x++;
            // y++;
            this.changep();
            drawPanel.repaint();

            try{
                Thread.sleep(100);
            }catch(Exception ex){}
        }

    }

    public void changep(){
        y=(int) ((Math.pow(x, 1.05)-1) % 300);
        x=(int) ((Math.pow(x, 1.03)-2) % 300);
    }

    class MyDrawPanel extends JPanel{
        public  void paintComponent(Graphics g){
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }

}
