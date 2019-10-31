import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;  
import java.awt.event.*;  
import java.sql.*;
public class app  extends JFrame{ 
	
	JFrame f;String Data1;
	 JTextField t1,t2; JPasswordField value,value1;
app(){
	this.f=new JFrame("Login"); 
	 f.setSize(800, 600);
	 
	 //student
	 JLabel l3=new JLabel("Student Login");
	 l3.setBounds(180,200, 200,30);
	 
	 
	 JLabel l1=new JLabel("RegID:");
	 l1.setBounds(50,260, 80,30);
	    t1=new JTextField();  
	    t1.setBounds(160,260, 150,30);  
	 
      value = new JPasswordField();   
     JLabel l2=new JLabel("Password:");    
        l2.setBounds(50,320, 80,30);    
         value.setBounds(160,320,150,30); 
         
            JButton b=new JButton("Login Student");  
            b.setBounds(160,380,150,30);  
            b.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		   
                      
                      try {
                    	  
                    	String url="jdbc:mysql://10.10.15.202:3306/t3469db";
						String user="t3469";
						String pass="t3469";

						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,user,pass);
              			
              			PreparedStatement st=null;
              			
              			ResultSet rs=null;
              			
              			String pass =  new String(value.getPassword()); 
              			String regId = t1.getText();
              			
              			st = con.prepareStatement("select student_clg_id from student where student_clg_id=? AND student_pass=?");
						st.setString(1,regId);
						st.setString(2,pass);
						rs= st.executeQuery();

						if(rs.next()) {
							
							JOptionPane.showMessageDialog(null,"Successfully LoggedIn");
							JFrame f1=new JFrame("After Login"); 
		            		 f1.setSize(800, 600);
		            		   
		                      
		                      st = con.prepareStatement("select book_name,book_author from books");
							  rs= st.executeQuery();
							  DefaultTableModel model = new DefaultTableModel(new String[]{"Book Name", "Book Author"}, 0);
							  
		                 
							  while(rs.next())
							  {
							      String d = rs.getString("book_name");
							      String e1 = rs.getString("book_author");
							      model.addRow(new Object[]{d, e1, f1});
							  }
		                           
		                      
		                      JTable jt=new JTable(model);    
		                      jt.setBounds(110,40,500,200);          
		                      JScrollPane sp=new JScrollPane(jt); 
		                      
		                     
		                      
		                      jt.setCellSelectionEnabled(true);  
		                      ListSelectionModel select= jt.getSelectionModel();  
		                      select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		                      select.addListSelectionListener(new ListSelectionListener() {  
		                        public void valueChanged(ListSelectionEvent e) {  
		                          String Data = null;  
		                          JTextField t;
		                          int[] row = jt.getSelectedRows();  
		                          int[] columns = jt.getSelectedColumns();  
		                          for (int i = 0; i < row.length; i++) {  
		                            for (int j = 0; j < columns.length; j++) {  
		                              Data = (String) jt.getValueAt(row[i], columns[j]);  
		                            } 
		                          } 
		                          
		                          JOptionPane.showMessageDialog(null,"You Have Issued Book :"+Data);  
		                         try {
		                        	 PreparedStatement st = con.prepareStatement("insert into issued_books values(?,?,?,?)");
										st.setString(1,Data);
										st.setString(2, t1.getText());
										st.setString(3,"2018-10-15");
										st.setString(4,"2018-10-22");
										st.executeUpdate();
		                         }
		                         catch(Exception e1) {
		                       	  e1.printStackTrace();
		                         }
		                        }       
		                      }); 
		 
		                      
		                      f1.add(sp); f1.add(jt);         
		                      f1.setLayout(null);    
		                      f1.setVisible(true);
		                      f.setVisible(false);
						}
						else {
							
							JOptionPane.showMessageDialog(null,"Login Credentials Failed");
						}
              			
                    	  
                      }
                      catch(Exception e1) {
                    	  e1.printStackTrace();
                      }
            	}

            });
            
         
         
     //admin
         JLabel l4=new JLabel("Admin Login");
    	 l4.setBounds(480,200, 200,30);
    	 
    	   
    	 JLabel l5=new JLabel("RegID:");
    	 l5.setBounds(350,260, 80,30);
    	    t2=new JTextField();  
    	    t2.setBounds(450,260, 150,30);  
    	 
          value1 = new JPasswordField();   
         JLabel l6=new JLabel("Password:");    
            l6.setBounds(350,320, 80,30);    
             value1.setBounds(450,320,150,30); 
         
             JButton b1=new JButton("Login Admin");  
             b1.setBounds(450,380,150,30);  
             b1.addActionListener(new ActionListener() {
            	 public void actionPerformed(ActionEvent e) {
            		 try {
            			  
                     	Class.forName("com.mysql.jdbc.Driver");
               			
               			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","suraj2304");
               			
               			PreparedStatement st=null;
               			
               			ResultSet rs=null;
               			
               			String pass =  new String(value1.getPassword()); 
              			String regId = t2.getText();
              			
              			st = con.prepareStatement("select admin_fname from admin where admin_clg_id=? AND admin_pass=?");
						st.setString(1,regId);
						st.setString(2,pass);
						rs= st.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"Successfully LoggedIn");
							JFrame f2=new JFrame("After Login"); 
		            		 f2.setSize(800, 600);
		            		 
		                      
		                      st = con.prepareStatement("select book_name,student_id from issued_books");
							  rs= st.executeQuery();
							  DefaultTableModel model1 = new DefaultTableModel(new String[]{"Book Name", "StudentID"}, 0);
							  
							  while(rs.next())
							  {
							      String d = rs.getString("book_name");
							      String e1 = rs.getString("student_id");
							      model1.addRow(new Object[]{d, e1, f2});
							  }
		                           
		                      
		                      JTable jt=new JTable(model1);    
		                      jt.setBounds(110,40,500,200);          
		                      JScrollPane sp=new JScrollPane(jt); 
		                      
							  
		                      f2.add(sp); f2.add(jt); 
							  f2.setLayout(null);    
		                      f2.setVisible(true);
		                      f.setVisible(false); 
						}
						else {
							
							JOptionPane.showMessageDialog(null,"Login Credentials Failed");
						}
						
						
            		 }
            		catch(Exception e2) {
            			 e2.printStackTrace();
            		}
            	 }
             });
         
            f.add(value);
            f.add(t1); 
            f.add(l1);  
            f.add(l2);  
            f.add(l3);
            f.add(value1);
            f.add(t2); 
            f.add(l4);  
            f.add(l5);  
            f.add(l6);f.add(b);f.add(b1);
            f.setLayout(null);    
            f.setVisible(true);     
}
public static void main(String[] args) { 
	
	new app();
}
}  
