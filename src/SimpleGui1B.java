import javax.swing.*;
import java.awt.event.*;



public class SimpleGui1B implements ActionListener{
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B()    ;
        gui.go();
    }


    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        button.setText("I am clicked");
    }
}
