package com.project.services;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.util.DbConnectionUtil;
import com.project.model.Contact;



public class MenuService {

	DaoImplementation dao;
	Scanner sc = new Scanner(System.in);
	
	public MenuService() {
		
		dao=new DaoImplementation();

		
	}

	
	public void addData() {
		System.out.println("Enter Name :");
		String name = sc.next();
		System.out.println("Enter Address :");
		String address = sc.next();
		System.out.println("Enter Mobile Number");
		int mobileNumber = sc.nextInt();
		System.out.println("Enter Image Reference");
		String imageReference = sc.next();
		System.out.println("Enter new Date of Birth (YYYY-MM-DD) -");
		String dateOfBirth = sc.next();
		System.out.println("Enter E-mail");
		String email = sc.next();
		System.out.println("Group: Enter your choice :");
		System.out.println("Personal, Friends ,Professional ,Relatives ,Other ");
		sc.nextLine();
		String groupName = sc.nextLine();
		System.out.println(groupName);
		Contact contact = new Contact(name,address,mobileNumber,imageReference,LocalDate.parse(dateOfBirth),email,groupName);
		
		System.out.println(dao.add(contact));
		
		
	
		
		
	}
	
	
	public boolean removeByMobileNo() {

		int mobileNo=sc.nextInt();
		if(dao.remove(mobileNo)==1) {
			System.out.println("Successful!!!");
			return true;
		}else {
			System.out.println("Error!!");
			return false;
		}
			
	}
	
	
	
	public void showData() {
		dao.displayAll();
	}
	
	
	public void updateData() {
		System.out.println("Enter name of person : ");
		String name=sc.next();
		System.out.println("Enter new mobile number");
		int number=sc.nextInt();
		dao.updateMobile(name,number);
		
	}
	
	
	public void genReport() {
		System.out.println("Do you want to generate report in File or Console  :choose 1 for file & 2 for console:");
		int genChoice=sc.nextInt();
		if(genChoice==1) {
			dao.generateReport(1);
		}else if(genChoice==2){
			dao.generateReport(2);
		}else {
			System.out.println("Wrong Choice");
		}
	}
	
	
	
}
