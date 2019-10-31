/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment1;
import java.util.*;
        
public class Assignment1 {
    public static void main(String[] args) {
        Datastructures d=new Datastructures();
     Scanner in=new Scanner(System.in);
     int choice;
     System.out.println("MENU"
             + "\n1)Vector"
             + "\n2)Stack"
             + "\n3)Properties"
             + "\n4)Dictionary"
             + "\n5)Exit");
     choice=in.nextInt();
     switch(choice)
     {
         case 1:
             d.VectorImplementation();
             break;
         case 2:
             d.StackImplementation();
             break;
         case 3:
             d.PropertiesImplementation();
             break;
         case 4:
             d.DictionaryImplementation();
             break;
     }
     }
}
