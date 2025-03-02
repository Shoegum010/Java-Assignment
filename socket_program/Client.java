import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args){
		try{

			//initializing Socket
			Socket s = new Socket("localhost", 3000);

			DataOutputStream d = new DataOutputStream(s.getOutputStream());

			d.writeUTF("sairam to server!!");

			d.flush();

			d.close();

			s.close();

		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}