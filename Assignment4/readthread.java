


import java.io.*;
import java.net.*;
//import client.clientapp;

public class readthread implements Runnable
{

	  private BufferedReader reader;
	  private Socket socket;
	  private  clientapp client1;
	  
	  public readthread(clientapp client1,Socket socket)
	  
	  {
		this.client1=client1;
		this.socket=socket;
		  try {
	            InputStream input = socket.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(input));
	        } catch (IOException ex) {
	            System.out.println("Error getting input stream: " + ex.getMessage());
	            
	        }
	  }
	 
	  public void run()
	  {
	 
	  while(true)
	  {
		  try{
		  
		  String msg= reader.readLine();
		  
		  System.out.println(msg);
		  
		  }
		  
		  catch (IOException ex) {
              System.out.println("Error reading from server: " + ex.getMessage());
              ex.printStackTrace();
              
          }
          }
          
	  }
	

	
}
