/*Note:
 *     This is an example of BoxLayout 
 *     Knowledge:
 *         BoxLayout --- In its vertical mode (BoxLayout.Y_AXIS), force new component to next line.
 *         You can change the default layout manager for JPanel to BoxLayout, BorderLayout,..
 *
 */             

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class BoxLayout1{


    public static void main(String [] args){
        String methodName = "go" + args[0];

        BoxLayout1 gui = new BoxLayout1();
        gui.go(gui, methodName);
    }

    
    public void go(BoxLayout1 gui, String methodName){

        try{
            Method m = gui.getClass().getDeclaredMethod(methodName, (Class <?> [])null);
            m.invoke(gui, (Object [])null);
        }catch (Exception e){
            e.printStackTrace();
        }// end try
    }// end method

    public void go1(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public void go2(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        JButton button = new JButton("Click me");

        panel.add(button);
        frame.getContentPane().add(BorderLayout.EAST,panel);

        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public void go3(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Click me");
        JButton button2 = new JButton("bliss");

        panel.add(button);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
