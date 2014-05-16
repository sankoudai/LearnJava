import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI3C implements ActionListener{
    JFrame frame;

    public static void main(String[] args) {
        SimpleGUI3C gui = new SimpleGUI3C();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

       int red = (int) (Math.random()*255);
       int green = (int) (Math.random()*255);
       int blue = (int) (Math.random()*255);

        Color color = new Color(red, green, blue);
        g.setColor(color);
        g.fillOval(50, 50, 30, 30);
    }
}
