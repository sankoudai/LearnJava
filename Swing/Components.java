import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class Components{

    JTextField field;
    JTextArea  text;
    JCheckBox check;
    JList list; 


    public static void main(String [] args){
        String methodName = "go"+args[0];
        Components gui = new Components();
        gui.go(gui, methodName);
    }

    public void go(Components gui, String methodName){
        try{
            Method m = gui.getClass().getDeclaredMethod(methodName, (Class <?> [])null);
            m.invoke(gui, (Object [])null);

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }



    // JTextField
    public void go1(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        field = new JTextField(20); // preferred width: 20 columns

        field.setText("Your name");
        System.out.println(field.getText());

        field.selectAll();  // seclect All text
        field.requestFocus();
        field.addActionListener(new TextFieldChanger());


        frame.getContentPane().add(BorderLayout.CENTER,field);

        frame.setSize(200,200);
        frame.setVisible(true);
    }

    // JTextArea
    public void go2()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Just click it");
        button.addActionListener(new TextAreaChanger());

        text = new JTextArea(10, 20); // 10 lines * 20 columns
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350, 300);
        frame.setVisible(true);
    } // end method

    
    //JCheckBox
    public void go3(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        check = new JCheckBox("Calm to think");
        check.setSelected(false);
        check.addItemListener(new CheckBoxChanger());

        frame.getContentPane().add(BorderLayout.NORTH, check);
        
        frame.setSize(200, 200);
        frame.setVisible(true);
    } // end method

    //JList: Note ListSelectionListener is defined in javax.swing.event.*;
    public void go4(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String [] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta"};
        list = new JList(listEntries);

        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListChanger());

        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    } // close method

    class ListChanger implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent lse){
            if (!lse.getValueIsAdjusting()){
                String selection = (String) list.getSelectedValue();
                System.out.println(selection);
            }
        }
    } // close inner class


    class CheckBoxChanger implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            String onOff = "off";
            if (check.isSelected()) onOff = "on";
            System.out.println("Checkbox is " + onOff );
        }
    }



    class TextAreaChanger implements ActionListener{
        public void actionPerformed(ActionEvent event){
            text.append("button clicked\n");
        }

    }



    class TextFieldChanger implements ActionListener{
        public void actionPerformed(ActionEvent event){
            field.setText("");

        }
    }
}
