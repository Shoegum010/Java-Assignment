import java.io.*;
import java.net.*;

public class Server4 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("Server is waiting...");

            while (true) {
                Socket s = ss.accept();
                System.out.println("Connected to client: " + s);

                // Create a new thread to handle this client
                ClientHandler clientHandler = new ClientHandler(s);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Class to handle client communication
class ClientHandler implements Runnable {
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private BufferedReader userInput;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            userInput = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Thread for reading messages from the client
            Thread readThread = new Thread(() -> {
                try {
                    String msg;
                    while (!(msg = dataIn.readUTF()).equals("over")) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            // Thread for sending messages to the client
            String msgToSend;
            while (true) {
                System.out.print("Server: ");
                msgToSend = userInput.readLine();
                dataOut.writeUTF(msgToSend);
                if (msgToSend.equals("over")) {
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

