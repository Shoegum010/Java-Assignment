import java.io.*;
import java.net.*;

public class Client3{
    public static void main(String[] args) {
        try {
            
            Socket s = new Socket("localhost",8000);
            System.out.println("connected to the server.");

            DataInputStream dataIn = new DataInputStream(s.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());

            //for receiving fron the server
            Thread readThread = new Thread(()->{
                try {
                    String msg;
                    while (!(msg=dataIn.readUTF()).equals("over")) {
                        System.out.println("Server: " +msg);
                    }
                    System.out.println("chat ended");
    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();
            //main thread writing to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String msgToSend;
            while (true) {
                System.out.println("Client :");
                msgToSend = userInput.readLine();
                dataOut.writeUTF(msgToSend);
                if (msgToSend.equals("over")) {
                    break;
                }
            }

            s.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}