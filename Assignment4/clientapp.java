

import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;


import javax.swing.JTextArea;
import javax.swing.JOptionPane;

//import client.readthread;
//import client.writethread;


class c_page extends JFrame implements ActionListener{
	
	clientapp app1;
	Container c;
	String error1;
	
		CardLayout card;
		JTextArea t2;
		JButton b1,b2,b3;
		String emp,task;
		JPanel jp2 = new JPanel();
		public static JLabel l1,l2;
		c_page()
		{
			c = getContentPane();
			card = new CardLayout(50,50);
			c.setLayout(card);
			l1 = new JLabel("TASK MANAGER FOR MANAGERS");
			l1.setBounds(20,20,100,30);
			
			l2 = new JLabel("Waiting for connection");
			l2.setBounds(20,20,100,30);
			
			//t1 = new JTextArea("Enter Emp name");
			//t1.setBounds(20,20,100,30);
			//t1.setVisible(true);
			t2 = new JTextArea("Enter Task");
			t2.setBounds(20,20,100,30);
			t2.setVisible(true);
			
			b3 = new JButton("Submit");
			b3.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					//emp = t1.getText();
					task = t2.getText();
					app1.send(task);
					
				}
			});
			
			
			
			b1 = new JButton("Start adding Tasks");
			b1.addActionListener(this);
			b2 = new JButton("Connect to server");
			b2.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					app1=new clientapp();
					error1=app1.execute();
					 //l2.setText("YOO");
					// c.remove(jp2);
					// jp2.add(l2);jp2.add(b2);
					// c.add("next",jp2);
					// repaint();
					// revalidate();
					// card.show(c,"next");
					if(error1.equals("null"))
					{
						JOptionPane.showMessageDialog(null,"Connection Successful", "InfoBox:Connection", JOptionPane.INFORMATION_MESSAGE);
						card.next(c);
						
					}
					
					else
					{
						
					JOptionPane.showMessageDialog(null,"Connection Failed", "InfoBox:Connection", JOptionPane.INFORMATION_MESSAGE);
					card.show(c,"next");
					
					}
				}
			
			});
			JPanel jp1 = new JPanel();
			jp1.add(l1);jp1.add(b1);
			
			JPanel jp3 = new JPanel();
			jp3.add(t2);jp3.add(b3);
			
			
			jp2.add(l2);jp2.add(b2);
			//c.add("connect",b1);
			c.add("connect",jp1);
			c.add("next",jp2);
			c.add("task",jp3);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			card.next(c);
		}
		
	}


public class clientapp extends c_page {
	
	private PrintWriter writer;
	 private Socket socket;
    private OutputStream output;
    String error1;
    
	
	public void send(String task)
	{
		writer.println(task);
	}
	
	public String execute()
	{
		error1 = "null";
	try{
	 socket = new Socket("localhost",3330);
	//Runnable r1= new readthread(this,socket);
	//Runnable w1 = new writethread(this,socket);
	
	 try {
          output = socket.getOutputStream();
         writer = new PrintWriter(output, true);
         
     } catch (IOException ex) {
         System.out.println("Error getting output stream: " + ex.getMessage());
         ex.printStackTrace();
     }
	
	//ExecutorService pool = Executors.newFixedThreadPool(2);
	
	// pool.execute(r1);
	 //pool.execute(w1); 
	//r1.start();
	//w1.start();
	//pool.shutdown();
	
		}
	 catch (IOException ex) {
         System.out.println("I/O Error: " + ex.getMessage());
         String error1 = ex.getMessage();
         return error1;
     }
     
	return error1;
	}
	
	public static void main(String args[])
	{
		//clientapp app1=new clientapp();
		c_page cp = new c_page();
		cp.setSize(400,400);
		cp.setVisible(true);
		cp.setDefaultCloseOperation(cp.EXIT_ON_CLOSE);  
		//app1.execute();
	}
}
