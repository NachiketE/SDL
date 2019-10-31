

import java.io.*;
import java.net.*;
import java.util.Scanner;

//import client.clientapp;

public class writethread implements Runnable{

	private PrintWriter writer;
    private Socket socket;
    private clientapp  client1;
    
    public writethread(clientapp client1,Socket socket)
    {
    	this.client1=client1;
    	this.socket=socket;
    	

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void run()
    {
    	 Scanner s1= new Scanner(System.in);
    	 String text;
    	 
         do {
        	 text = s1.nextLine();
             writer.println(text);
  
         } while (!text.equals("stop"));
  
         try {
             socket.close();
         } catch (IOException ex) {
  
             System.out.println("Error writing to server: " + ex.getMessage());
         }
    }
 
	
}
