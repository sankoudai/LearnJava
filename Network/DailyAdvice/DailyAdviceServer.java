import java.net.*;
import java.io.*;

public class DailyAdviceServer{

    String [] adviceList = {"Take smaller bites", "go for tight jeans", "one word: inappropriete",
        "just for today, be honest. Tell your boss what you think", "rethink the hairecut"};

    public static void main(String [] args){
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    public void go(){

        try {
            ServerSocket serverSock = new ServerSocket(5000);

            while (true){
                Socket socket = serverSock.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch (Exception e){e.printStackTrace();}
    } // close method

    public String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    } // close method


}
