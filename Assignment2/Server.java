import java.net.*; 
import java.io.*; 
  
public class Server 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
    private DataInputStream in       = null; 
  	ArrayList<String> al=new ArrayList<String>();
    // constructor with port 
    public Server(int port) 
    { 

        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream()));
            
            input  = new DataInputStream(System.in); 
            
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            try
        	{ 
           		line = input.readLine(); 
	         	out.writeUTF(line);
	      	}
	          catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            while(!line.equals("Over"))
            {
	                try
	                { 
	                    line = in.readUTF(); 
	                    System.out.println(line); 
	                    al.add(line);
	                    line = input.readLine(); 
	                    out.writeUTF(line);
	                } 
	                catch(IOException i) 
	                { 
	                    System.out.println(i); 
	                } 
            }
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            in.close(); 
            input.close();
            out.close();
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        Server server = new Server(8000); 
    } 
} 
