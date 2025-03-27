import java.io.*;
import java.net.*;

public class Server3{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("Server is waiting...");
            Socket s = ss.accept();
            System.out.println("Connected to client");

            DataInputStream dataIn = new DataInputStream(s.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());

            //thread for receiving the message
            Thread readThread = new Thread(()->{
                try {
                    
                    String msg;
                    while(!(msg = dataIn.readUTF()).equals("over")){
                        System.out.println("client: " + msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            //thread for sending the message to the client.
           BufferedReader  userInput = new BufferedReader(new InputStreamReader(System.in));
           try {
            String msgToSend;
            while (true) {
                System.out.println("Server: ");
                msgToSend = userInput.readLine();
                dataOut.writeUTF(msgToSend);
                if (msgToSend.equals("over")) {
                    break;
                }
            }

           } catch (IOException e) {
                e.printStackTrace();
           } 

           ss.close();
           s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}