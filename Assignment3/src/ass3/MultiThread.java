package ass3;
import java.net.*;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;
class ServerClientThread implements Runnable {
	String name;
	public ServerClientThread() 
    { 
    } 
  Socket serverClient;
  int clientNo;
  int squre;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  synchronized void update(PreparedStatement ps)
  {
	  try
	  {
		ps.executeUpdate();
	  }
	  catch(Exception ex)
	  {
	      System.out.println(ex);
	  }
	  
  }
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
			String url="jdbc:mysql://10.10.15.202:3306/t3469db";
			String user="t3469";
			String pass="t3469";
		
			String sql="create table student (name varchar(20),roll varchar(20),cls varchar(20),dob date,gender varchar(20),city varchar(20))";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			Statement st=con.createStatement();
			PreparedStatement ps;
			//ResultSet rs = null;
			//int i1=rs.getInt(1);
			//String s1=rs.getString(2);
			//System.out.println(i1+"  "+s1);
			//st.executeUpdate(sql);
			//ResultSet m=st.executeQuery(sql1);
			//m.next();
			//System.out.println(m);
			//ResultSet n=st.executeQuery(sql2);
			//while(n.next())  
			    //System.out.println(n.getInt(1)+"\t"+n.getString(2)+"\t"+n.getString(3) +"\t"+ n.getInt(4)/*+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)*/);  
			//System.out.println(n);
			int op=0;
			String name,cls,roll,city,dob,gender;
			while(op!=-1)
			{
				String menu="1. Insert Student Data :- \n"+"2. Fetch details of particular Student :- \n"+"3. Clear all Students :- \n"+"4. Total no of Students :- \n"+"5. Details of all Students :- \n"+"6. Display Male Students :- \n"+"7. Display Female Students :- \n"+"8. Modify Students Data :- \n"+"9. Delete Specific Student Data :- \n"+"Enter option";
				outStream.writeUTF(menu);
				String tp=inStream.readUTF();
				op=Integer.parseInt(tp);
				switch(op)
				{
				case 1: 
						outStream.writeUTF("Enter Students Name :- ");
						name=inStream.readUTF();
						outStream.writeUTF("Enter Students Roll No :- ");
						roll=inStream.readUTF();
						outStream.writeUTF("Enter Students Class :- ");
						cls=inStream.readUTF();
						outStream.writeUTF("Enter Students DOB :- ");
						dob=inStream.readUTF();
						outStream.writeUTF("Enter Students Gender :- ");
						gender=inStream.readUTF();
						outStream.writeUTF("Enter Students City :- ");
						city=inStream.readUTF();
						
						ps=con.prepareStatement("Insert into student values(?,?,?,?,?,?)");
						ps.setString(1,name);
						ps.setString(2,roll);
						ps.setString(3,cls);
						ps.setString(4,dob);
						ps.setString(5,gender);
						ps.setString(6,city);
						ps.executeUpdate();
						String s1="Student Data Inserted.";
						outStream.writeUTF(s1);
						s1=inStream.readUTF();
						break;
						
				case 2: 
						outStream.writeUTF("Enter Students Name :- ");
						name=inStream.readUTF();
						ps=con.prepareStatement("select * from student where name=(?)");
						ps.setString(1,name);
						ResultSet rs=ps.executeQuery();
						String res="";
						//res+=(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3) +"\t"+ rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\n");
						while(rs.next())
						{
							res+=(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3) +"\t"+ rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\n");
						}
						//System.out.println(res);
						outStream.writeUTF(res);
						res=inStream.readUTF();
						break;
						
				case 3: ps=con.prepareStatement("delete from student");
						int rs1=ps.executeUpdate();
						//System.out.println(rs1);
						if(rs1==1)
						{
							String ss="Table Data Cleared.";
							outStream.writeUTF(ss);
							ss=inStream.readUTF();
						}
						break;
						
				case 4: ps=con.prepareStatement("SELECT COUNT(*) FROM student");
						int ct=0;
						ResultSet rs6=ps.executeQuery();
						while(rs6.next())
						{
							ct = rs6.getInt(1);
						}
						String s="The total no of Students are :- "+ct;
						System.out.println(s);
						
						
						outStream.writeUTF(s);
						s=inStream.readUTF();
						break;
						
				case 5: ps=con.prepareStatement("select * from student");
						ResultSet rs2=ps.executeQuery();
						String s3="";
						while(rs2.next())
						{
							s3+=rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3) +"\t"+ rs2.getString(4)+"\t"+rs2.getString(5)+"\t"+rs2.getString(6)+"\n";
						}
						outStream.writeUTF(s3);
						s3=inStream.readUTF();
						break;
						
						
				case 6: ps=con.prepareStatement("select * from student where gender='M'");
						ResultSet rs3=ps.executeQuery();
						String s4="";
						while(rs3.next())
						{
							s4+=rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3) +"\t"+ rs3.getString(4)+"\t"+rs3.getString(5)+"\t2"+rs3.getString(6);
						}
						outStream.writeUTF(s4);
						s4=inStream.readUTF();
						break;
						
				case 7: ps=con.prepareStatement("select * from student where gender='F'");
						ResultSet rs4=ps.executeQuery();
						String s5="";
						while(rs4.next())
						{
							s5+=rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getString(3) +"\t"+ rs4.getString(4)+"\t"+rs4.getString(5)+"\t2"+rs4.getString(6);
						}
						outStream.writeUTF(s5);
						s5=inStream.readUTF();
						break;
				
				case 8: 
						outStream.writeUTF("Enter Students Name whose Data U want to Modify:-");
						name=inStream.readUTF();
						ps=con.prepareStatement("delete from student where name=(?)");
						ps.setString(1,name);
						ps.executeUpdate();
						outStream.writeUTF("Enter Students Roll No :- ");
						roll=inStream.readUTF();
						outStream.writeUTF("Enter Students Class :- ");
						cls=inStream.readUTF();
						outStream.writeUTF("Enter Students DOB :- ");
						dob=inStream.readUTF();
						outStream.writeUTF("Enter Students City :- ");
						city=inStream.readUTF();
						outStream.writeUTF("Enter Students Gender :- ");
						gender=inStream.readUTF();
						ps=con.prepareStatement("Insert into student values(?,?,?,?,?,?)");
						ps.setString(1,name);
						ps.setString(2,roll);
						ps.setString(3,cls);
						ps.setString(4,dob);
						ps.setString(5,gender);
						ps.setString(6,city);
						update(ps);
						outStream.writeUTF("Student Data Modified.");
						String to=inStream.readUTF();
						break;
				
				case 9: ps=con.prepareStatement("delete from student where name=(?)");
						outStream.writeUTF("Enter Students Name whose Data you want to Delete :- ");
						name=inStream.readUTF();
						ps.setString(1,name);
						int rs5=ps.executeUpdate();
						//System.out.println(rs1);
						if(rs5==1)
							outStream.writeUTF("Table Data Cleared.");
						String ss1=inStream.readUTF();
						break;
				}
			}
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}
public class MultiThread {
  public static void main(String[] args) throws Exception {
    try{
      ServerSocket server=new ServerSocket(8888);
      int counter=0,in=0;
      System.out.println("Server Started ....");
      ExecutorService pool = Executors.newFixedThreadPool(2);
      Runnable r1,r2;
      while(true){
        counter++;
        Socket serverClient=server.accept();  //server accept the client connection request
        System.out.println(" >> " + "Client No:" + counter + " started!");
        if(counter%2==0)
        {
        	r1 = new ServerClientThread(serverClient,counter);
        	pool.execute(r1);
        	//Thread object = new Thread(new ServerClientThread(serverClient,counter)); //send  the request to a separate thread
            //object.start(); 
        }
        else
        {
        	r2 = new ServerClientThread(serverClient,counter);
        	pool.execute(r2);
        	//Thread object = new Thread(new ServerClientThread(serverClient,counter)); //send  the request to a separate thread
            //object.start(); 
        }
        
        
      }
    }catch(Exception e){
      System.out.println(e);
    }
  }
}