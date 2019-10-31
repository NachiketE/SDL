/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Student {
    Scanner in=new Scanner(System.in);
    String name;
    int roll;
    float marks;
    Student()
    {
        name="Empty";
        roll=0;
        marks=0;
    }
    Student(String name,int roll,float marks)
    {
        this.name=name;
        this.roll=roll;
        this.marks=marks;
    }
    
    public void getdata()
    {
        System.out.println("Enter Student Name : ");
        name=in.next();
        System.out.println("Enter Student Roll No. : ");
        roll=in.nextInt();
        System.out.println("Enter Student Marks : ");
        marks=in.nextInt();
    }
    public void Display()
    {
        System.out.println("Name : "+name);
        System.out.println("Roll No.: "+roll);
        System.out.println("Marks : "+marks);
    }
}
