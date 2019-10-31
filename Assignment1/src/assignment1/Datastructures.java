/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.util.*;
import java.io.*;
/**
 *
 * @author student
 */
public class Datastructures {
    Scanner in=new Scanner(System.in);
    public void VectorImplementation()
    {
        System.out.println("Enter Intial Capacity ");
        int capacity=in.nextInt();
        System.out.println("Enter Increment");
        int incre=in.nextInt();
        int choice;
        Vector v=new Vector(capacity,incre);
        do{
            
        System.out.println("Menu"
                + "\n1)Insert Value"
                + "\n2)Remove Value"
                + "\n3)Check Size"
                + "\n4)Check Capacity"
                + "\n5)Check Is Empty"
                + "\n6)Insert Value At Index"
                + "\n7)Display Entire Vector"
                + "\n8)Exit");
       choice=in.nextInt();
       int value;
       switch(choice)
       {
           case 1:
               System.out.println("Enter Value to Insert : ");
               value=in.nextInt();
               v.add(value);
               break;
           case 2:
                System.out.println("Enter Index from which to delete : ");
                value=in.nextInt();
                v.remove(value);
                break;
           case 3:
               System.out.println("No of elements in vector are : "+v.size());
               break;
           case 4:
               System.out.println("Capacity of vector are : "+v.capacity());
               break;
           case 5:
               if(v.isEmpty())
                   System.out.println("Empty");
               else
                   System.out.println("Not Empty");
               break;
           case 6:
                int index;
                System.out.println("Enter Value ");
                value=in.nextInt();
                System.out.println("Enter Index ");
                index=in.nextInt();
                v.add(index, value);
                break;
           case 7:
               System.out.println(v);
               break;
       }
       }
       while(choice!=8);
  }
    public void StackImplementation()
    {
        System.out.println("Enter Intial Capacity ");
        int capacity=in.nextInt();
        System.out.println("Enter Increment");
        int incre=in.nextInt();
        int choice;
        Stack v=new Stack();
        do{
            
        System.out.println("Menu"
                + "\n1)Push Value"
                + "\n2)Pop Value"
                + "\n3)Check Size"
                + "\n4)See Top Entry"
                + "\n5)Check Is Empty"
                + "\n6)Check how deep the element is "
                + "\n7)Exit");
       choice=in.nextInt();
       int value;
       switch(choice)
       {
           case 1:
               System.out.println("Enter Value to Push on stack : ");
               value=in.nextInt();
               v.push(value);
                break;
           case 2:
                System.out.println("Element Popped is "+v.pop());
                break;
           case 3:
               System.out.println("No of elements in stack are : "+v.size());
               break;
           case 4:
               System.out.println("Top of the stack is "+v.peek());
               break;
           case 5:
               if(v.empty())
                   System.out.println("Empty");
               else
                   System.out.println("Not Empty");
               break;
           case 6:
               System.out.println("Enter Value to Push on stack : ");
               value=in.nextInt();
               int index=v.search(value);
               if(index==-1)
                   System.out.println("Element Not present in stack");
               else
                   System.out.println("Element at depth "+index);
               System.out.println(v);
               break;
       }
       }
       while(choice!=7);
  }
    public void DictionaryImplementation()
    {
        Dictionary d=new  Hashtable();
        int choice=0;
        do{
            
        System.out.println("Menu"
                + "\n1)Enumerate"
                + "\n2)Get A Value"
                + "\n3)Check if Empty"
                + "\n4)Enumerate keys"
                + "\n5)Put a Pair(Key,Value)"
                + "\n6)Remove a Value"
                + "\n7)Check size"
                + "\n8)Exit");
       choice=in.nextInt();
       int key,value;
       switch(choice)
       {
           case 1:
               Enumeration i;
               for(i =d.elements();i.hasMoreElements();)
               {
                   System.out.println("Value is "+i.nextElement());
                  
               }
               break;
           case 2:
              
               System.out.println("Enter Key to find value: ");
               key=in.nextInt();
               System.out.println("Value for given key is "+d.get(key));
               break;
           case 3:
               if(d.isEmpty())
                   System.out.println("Empty");
               else
                   System.out.println("Not Empty");
               break;
           case 4:
               
               Enumeration i2;
               for(i2 =d.elements();i2.hasMoreElements();)
               {
                   System.out.println("Key  is "+i2.nextElement());
                  
               }
               break;
           case 5:
               System.out.println("Enter Key Value Pair");
               key=in.nextInt();
               value=in.nextInt();
               d.put(key,value);
               break;
           case 6:
               System.out.println("Enter key to remove value : ");
               key=in.nextInt();
               d.remove(key);
               break;
           case 7:
               System.out.println("Size of Dictionary is "+ d.size());
               break;
       }
        }while(choice!=8);
        
    }
    public void BitSetImplementation()
    {
        BitSet b1=new BitSet();    //Default
        BitSet b2=new BitSet(10);
        
        System.out.println("Menu"
                + "\n1)Perform AND operation "
                + "\n2)Perform ANDNOT operation"
                + "\n3)Number of Set Bits "
                + "\n4)Clear bits"
                + "\n5)Check if Equlal"
                + "\n6)")
    }
    public void HashtableImplementation()
    {
        Hashtable<Integer,String> h=new Hashtable<Integer,String>();
        int key;
        String value;
        System.out.println("Hashtable is now emptied");
        h.clear();
        break;
        System.out.println("Enter Integer key to check");
        key=in.nextInt();
        if(h.containsKey(key))
            System.out.println("Key Present in HAshtable");
        else
             System.out.println("Key Present in HAshtable");
        break;
        System.out.println("Enter String to check");
        value=in.next();
        
        if(h.containsValue(value))
            System.out.println("Value Present in Hashtable");
        else
             System.out.println("Value Present in Hashtable");
        break;
        Enumeration i;
               for(i =h.elements();i.hasMoreElements();)
               {
                   System.out.println("Value is "+i.nextElement());
                  
               }
               break;
       System.out.println("Enter Integer key to check");
        key=in.nextInt(); 
       System.out.println(h.get(key));
            break;
            System.out.println("Enter Key ");
            key=in.nextInt();
            System.out.println("Enter Value");
            value=in.next();
            h.put(key, value);
            break;
             System.out.println("Enter key to remove value : ");
               key=in.nextInt();
               d.remove(key);
               break;
            
    }*/
    public void PropertiesImplementation()
    {
        int choice;
        String key,value;
        Properties p=new Properties();
     do
        {
        System.out.println("Menu"
                + "\n1)Get Property"
                + "\n2)Print List"
                + "\n3)Enumerate Keys"
                + "\n4Set Properties"
                + "\n5)Exit");
        choice=in.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter Key");
                key=in.next();
                System.out.println("Property at given key is "+p.getProperty(key));
                break;
            case 2:
                PrintWriter out=new PrintWriter(System.out);
                p.list(out);
                break;
            case 3:
                Enumeration i=p.propertyNames();
                for(;i.hasMoreElements();)
                System.out.println("property is "+i.nextElement());
                break;
            case 4:
                System.out.println("Enter Key : ");
                key=in.next();
                System.out.println("Enter value : ");
                value=in.next();
                p.setProperty(key, value);
                break;
        }
    }while(choice!=5);
    }
    
}
    
