/*Note:
 *     This is a simple example of ASCII IO.
 *     Knowledge:
 *         Write to a file: FileWriter(fileName).write("String to be written")
 *         Read from a file:
 *             FileReader fileReader = new FileReader(fileName);
 *             BufferedReader reader = new BufferedReader(fileReader);
 *             reader.readLine();
 */

import java.io.*;

public class PlainIO{
    String fileName = "PlainIO.txt";

    public static void main(String [] args){
        PlainIO pio = new PlainIO();
        pio.write();
        pio.read();
    }

    public void write(){
        try{
            FileWriter writer = new FileWriter(fileName);
            writer.write("What's 2+2? / 4\n");
            writer.write("What's 4+4? / 8\n");
            writer.close();
        }catch (Exception e){e.printStackTrace();}
    } // end method

    public void read(){
        try {
            //File myFile = new File(fileName);
            FileReader fileReader = new FileReader(fileName);  // connection stream for text file
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ( (line=reader.readLine()) != null)
                System.out.println(line);

            reader.close();
        } catch(Exception e){e.printStackTrace();}
    }
}
