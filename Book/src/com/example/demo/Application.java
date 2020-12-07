package com.example.demo;
import com.example.demo.services.*;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc=new Scanner(System.in);

int id=sc.nextInt();
String name=sc.next();
String auth=sc.next();
int price=sc.nextInt();
Book book1=new Book(id,name,auth,price);

BookService service=new BookService();
System.out.println(service.calculateDiscount(book1));
System.out.println(service.calculateSalary(book1, "Retail"));





		
	}

}
