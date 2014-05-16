import java.awt.*;
import javax.swing.*;

public class PaintMyWidget{
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel[] panel = new JPanel[20] ;
        // MyWidget1 w1 = new MyWidget1();
        // MyImage image = new MyImage();
        // ColorCircle circle = new ColorCircle();
        panel[0] = new MyWidget1();
        panel[1] = new MyImage();
        panel[2] = new ColorCircle();
        panel[3] = new GradientOval();
        panel[4] = new RandomGradientOval();


        int n = 4;



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(w1);
        // frame.getContentPane().add(image);
        // frame.getContentPane().add(circle);
        frame.getContentPane().add(panel[n]);


        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}

class MyWidget1 extends JPanel{

    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(3,4, 100, 200);

    }
}

class MyImage extends JPanel{
    public void paintComponent(Graphics g){
        Image image = new ImageIcon("desert.jpg").getImage();
        g.drawImage(image, 3, 4,this);

    }
}

class ColorCircle extends JPanel{
    public void paintComponent(Graphics g){
        g.fillRect(0, 0 , this.getWidth(), this.getHeight());

        int red = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);

        Color color = new Color(red, green, blue);
        g.setColor(color);
        g.fillOval(70, 70, 100, 100);
    }
}

class GradientOval extends JPanel{
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint paint = new GradientPaint(70,70, Color.blue, 150,150,Color.red);
        g2d.setPaint(paint);

        g2d.fillOval(70,70,100,100);

    }
}

class RandomGradientOval extends JPanel{
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random()*255);
        int green = (int) (Math.random()*255);
        int blue = (int) (Math.random()*255);
        Color startColor = new Color(red,green, blue);

        red = (int) (Math.random()*255);
        green = (int) (Math.random()*255);
        blue = (int) (Math.random()*255);
        Color endColor = new Color(red,green, blue);

        GradientPaint paint = new GradientPaint(70,70, startColor, 150,150,endColor);
        g2d.setPaint(paint);

        g2d.fillOval(70,70,100,100);

    }
}
