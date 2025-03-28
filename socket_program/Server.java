import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args){
		try{
			System.out.println("Starting Server...");
			
			ServerSocket ss = new ServerSocket(3000);
			System.out.println("Server Started on port 3000 ");
			
			//accepting connection from client
			Socket s = ss.accept();
			System.out.println("Client Connected");

			//Reading message from client
			DataInputStream d = new DataInputStream(s.getInputStream());
			String str = d.readUTF();
			System.out.println("Message from client: " + str );

			ss.close();
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}

	}
}