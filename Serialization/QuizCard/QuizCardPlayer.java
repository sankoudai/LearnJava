import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class QuizCardPlayer{

    private JFrame frame;
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args){
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    } // end method

    public void go(){
        // build gui

        frame = new JFrame("Quitz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);

        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }// close method

    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    } // close method

    private void loadFile(File file){
        cardList = new ArrayList<QuizCard>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while( (line=reader.readLine()) != null){
                makeCard(line);
            };
            reader.close();
        }catch(Exception e){
            System.out.println("Couldn't read the card file");
            e.printStackTrace();
        }

        showNextCard();
    }// end method

    private void makeCard(String lineToParse){
        String [] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }


    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next   Card");
                isShowAnswer = false;
            } else{
                if (currentCardIndex < cardList.size()){
                    showNextCard();
                }else{
                    display.setText("That was the last card");
                    nextButton.setEnabled(false);
                } // end inner if
            } // end outer if
        } // end method
    }// end inner class

    public class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    } // end inner class


}// end class
