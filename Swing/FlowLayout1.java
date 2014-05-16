/*Note:
 *     This is an example of FlowLayout
 *     Knowledge:
 *         FlowLayout is the default Layout manager for JPanel
 *         FlowLayout arrange items from left to right, with "wrap" turned on.
 *
 *         Techniques: dynamic method call 
 *             // Create obj from string className
 *             String className = "FlowLayout1"
 *             Class c = Class.forName();    
 *             Object obj = c.newInstance();  // Create new class instance
 *
 *             // To be studied...            
 *
 */             

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class FlowLayout1{


    public static void main(String [] args){
        String methodName = "go" + args[0];

        FlowLayout1 gui = new FlowLayout1();
        gui.go(gui, methodName);
    }

    
    public void go(FlowLayout1 gui, String methodName){

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

        JButton button = new JButton("Click me");
        JButton button2 = new JButton("bliss");

        panel.add(button);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
