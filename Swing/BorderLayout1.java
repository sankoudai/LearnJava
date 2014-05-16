/* Note:
 *     This is a simple example of Use BorderLayout
 *     Knowledge:
 *         BorderLayout is the default layout manager of JFrame.
 *         BorderLayout has five regions, NAMELY,  WEST, EAST, SOUTH, NORTH
 *         You can add only one component per region
 */

import javax.swing.*;
import java.awt.*;

public class BorderLayout1{
    public static void main(String [] args){

        BorderLayout1 gui = new BorderLayout1();
        gui.go4();

    }

    public void go1(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("click me ");
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }


    public void go2(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("click me like you mean it");
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }


    public void go3(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button = new JButton("click me ");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);

        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public void go4(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton east = new JButton("East");
        JButton west = new JButton("West");
        JButton south = new JButton("South");
        JButton north = new JButton("North");
        JButton center = new JButton("Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
