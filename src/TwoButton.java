import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
Concepts:
    Multiple widgets, events and Listener ---- How to connect them correspondingly?
    One way :
         Use different inner classes as listener secretaries of main GUI.
         Widget1--------Event---------->Inner class--------Changes-------->Widget2
         Like colorButton ------------->ColorListener--------------------->drawpanel
*/


public class TwoButton{
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButton gui = new TwoButton();
        gui.go();
    }

    public void go(){
        frame =  new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("I am a label");
        JButton lableButton = new JButton("Change label");
        lableButton.addActionListener(new LabelListener());

        MyDrawPanel drawPanel = new MyDrawPanel();
        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, lableButton);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Outch!");
        }
    }

}



class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        int red = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);

        Color color = new Color(red, green, blue);
        g.setColor(color);
        g.fillOval(50,50, 40,40);
    }
}
