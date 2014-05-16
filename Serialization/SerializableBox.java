/*Note
 *     This is a simple example of serialization and deserialization
 *     Knowledge:
 *         Steps to serialize an object:
 *             1. Make the class Serializable (implements Serializable)
 *             2. Make an obj
 *             3. Open I/O:
 *                 FileOutputStream fs = new FileOutputStream("mybox.ser");
 *                 ObjectOutputStream os = new ObjectOutputStream(fs);
 *             4. Write: os.writeObject(obj);
 *
 *          Steps to deserialize an object
 *              1. Open I/O:
 *                  FileInputStream fis = new FileInputStream("mybox.ser"); // byte-level stream
 *                  ObjectInputStream ois = new ObjectInputstream(fis);  // chain stream to obj
 *              2. Read as Object:
 *                  Object obj = ois.readObject();
 *              3. Convert to class:
 *                  SerializableBox newBox = (SerializableBox) obj;
 *
 *          What is serialized:
 *              Instance variables
 *              Object pointed to by them
 *              ...
 *
 *          Tricks:
 *              Variable defined in a block can only be seen within the block.
 *              Like in try/catch block,for block
 */


import java.io.*;

public class SerializableBox implements Serializable{

    private int width;
    private int height;

    public void setWidth(int w){
        width = w;
    }

    public int getWidth(){
        return width;
    }

    public void setHeight(int h){
        height = h;
    }

    public int getHeight(){
        return height;
    }

    public static void main(String [] args){

        SerializableBox box = new SerializableBox();
        box.setWidth(10);
        box.setHeight(15);
        System.out.println("The original box: " +  box.getWidth() +" * "+ box.getHeight());
        
        // serialize box
        try{
            FileOutputStream fs = new FileOutputStream("mybox.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(box);
            os.close();
        }catch (Exception e){e.printStackTrace();}

        // deserialize box to newBox
        try{
            FileInputStream fis = new FileInputStream("mybox.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SerializableBox newBox = (SerializableBox) ois.readObject();
            System.out.format("Deserialized box: %d * %d\n", newBox.getWidth(), newBox.getHeight()); 
            ois.close();
        }catch (Exception e2){e2.printStackTrace();}

    } // end method
}
