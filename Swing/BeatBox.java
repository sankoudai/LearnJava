import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox{
    
    JFrame frame;
    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;

    String [] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
            "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Canga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int [] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};


    public static void main(String [] args){
        new BeatBox().buildGUI();
    } // end main
    
    public void buildGUI(){
        frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);    // BorderLayout for JPanel
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // buttons 
        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton serializePattern = new JButton("Serialize");
        serializePattern.addActionListener(new MySendListener());
        buttonBox.add(serializePattern);

        JButton restorePattern = new JButton("Restore");
        restorePattern.addActionListener(new MyReadInListener());
        buttonBox.add(restorePattern);

        // Instrument Names
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i=0; i<16; i++){
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
        frame.getContentPane().add(background); // Why no location????

        // checkboxes
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);    // Grid Layout for main JPanel
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i=0; i<256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }// end loop
        

        // All about music
        setUpMidi();


        // Final 
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    } // close method

    
    public void setUpMidi(){
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }catch (Exception e){e.printStackTrace();}
    } // close method

    public void buildTrackAndStart(){
        int [] trackList = null;
        
        // get rid of old track
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i< 16; i++){ // for each instrument
            trackList = new int[16];

            int key = instruments[i];
            for (int j=0; j< 16; j++){
                JCheckBox c = (JCheckBox) checkBoxList.get(j+16*i);
                if(c.isSelected())
                    trackList[j] = key;
                else
                    trackList[j] = 0;
            } // close inner loop
            
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));  
        } // close outer loop 

        track.add(makeEvent(192, 9, 1, 0, 15)); 
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }catch(Exception e) {e.printStackTrace();}
    }  // close method


    public void makeTracks(int [] list){
        int length = list.length;
        int key;

        for (int i=0; i<length; i++){
            key = list[i];

            if (key !=0){
                track.add(makeEvent(144,9,key,100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        } // end for loop
    } // close method


    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage msg = new ShortMessage();
            msg.setMessage(comd, chan, one, two);
            event = new MidiEvent(msg, tick);
        }catch(Exception e) {e.printStackTrace();}

        return event;
    } // close method 

    public class MyStartListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            buildTrackAndStart();
        }
    } // close inner class

    public class MyStopListener implements ActionListener{
       public void actionPerformed(ActionEvent event) {
           sequencer.stop();
       }
    } // close inner class 

    public class MyUpTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor*1.03));
        }
    }// close inner class


    public class MyDownTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor*0.97));
        }
    } // close inner class

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            boolean[] checkboxState = new boolean[256];

            for(int i=0; i < 256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (check.isSelected()) 
                    checkboxState[i] = true;
            }

            try{
                FileOutputStream fs = new FileOutputStream(new File("checkbox.ser"));
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(checkboxState);
                os.close();
                JOptionPane.showMessageDialog(frame, "Your Pattern Is Successfully Serialized !");
            }catch (Exception e){ e.printStackTrace();}
        }// end inner method
    } // close inner class

    public class MyReadInListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            boolean checkboxState[] = null;
            try {
                FileInputStream fis = new FileInputStream(new File("checkbox.ser"));
                ObjectInputStream ois = new ObjectInputStream(fis);
                checkboxState = (boolean []) ois.readObject();
            }catch (Exception e){ e.printStackTrace();}

            for (int i=0; i<256; i++){
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if (checkboxState[i])
                    check.setSelected(true);
                else
                    check.setSelected(false);
            } // end for

            sequencer.stop();
            buildTrackAndStart();
            JOptionPane.showMessageDialog(frame, "Saved Pattern Loaded!");
        }
    }

}
