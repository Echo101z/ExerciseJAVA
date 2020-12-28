package com.project.apps;

import java.util.Scanner;
import com.project.services.*;

//import com.project.util.DbConnectionUtil;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		try {
//			System.out.println(DbConnectionUtil.getMySqlConnection());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
		
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		int choice=1;
		while(flag){
			MenuService menu=new MenuService();
			System.out.println("Welcome");
			System.out.println("Choose from below choice :");
			System.out.println("Enter 1 to add data from Console");
			
			System.out.println("Enter 2 to add data from CSV file");
			System.out.println("Enter 3 to Delete with mobile number");
			System.out.println("Enter 4 to Display Data");
			System.out.println("Enter 5 to update mobile number of a person ");
			System.out.println("Enter 6 to Generate Report ");
			System.out.println("Enter 7 to exit");
			System.out.print("Enter Choice :");
			choice=sc.nextInt();
			switch(choice) {
			case 1:	
					menu.addData();
					break;
			case 2:	CsvRead csvread=new CsvRead();
					csvread.readData();
					break;
					
			case 3: 
				System.out.println("Enter Mobile number to remove from database");
					menu.removeByMobileNo();
				break;
			case 4:
				System.out.println("DataBase Info :");
				menu.showData();
				break;
			case 5:	System.out.println("Enter name of person to update mobile number");
				menu.updateData();
				break;
			case 6:
				menu.genReport();	
				break;
			case 7:	
				flag=false;
				System.out.println("Exiting....");
				break;
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}

}
