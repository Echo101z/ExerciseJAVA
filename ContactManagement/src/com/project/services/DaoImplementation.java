package com.project.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.project.ifaces.*;
import com.project.model.Contact;
import com.project.util.*;


public class DaoImplementation implements DataAccess<Contact> {
	 
	private Connection con;
	String Name;
	String Address;
	String phoneNumber;
	String image;
	LocalDate dateOfBirth;
	String email;
	String group;
	Scanner sc;
	public DaoImplementation() {
		
		sc=new Scanner(System.in);
	try {
		this.con = DbConnectionUtil.getMySqlConnection();
	} catch (Exception e) {
		System.out.println("Connection Error");
	}
	
	this.Name=null;
	this.Address=null;
	this.dateOfBirth=null;
	this.email=null;
	this.image=null;
	this.phoneNumber=null;
	this.group=null;
	}
	
	
	@Override
	public int add(Contact contact) {
		// TODO Auto-generated method stub
		int rowadded=0;
		String addsql = "insert into contact values (?,?,?,?,?,?,?)" ;
		try(PreparedStatement pstmt = con.prepareStatement(addsql) ){
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getAddress());
			pstmt.setInt(3, contact.getMobileNumber());
			pstmt.setString(4, contact.getImageReference());		
			pstmt.setDate(5, Date.valueOf(contact.getDateOfBirth()));
			pstmt.setString(6, contact.getEmail());
			pstmt.setString(7, contact.getgroupId());

			rowadded = pstmt.executeUpdate();
			System.out.println("*********************Data Added****************************************");
		} catch (SQLException  e) {
			System.out.println("Unable to add contact! Already present");
			//e.printStackTrace();
		}
		

		return rowadded;
	}
		
		
	
	@Override
	public int update(Contact t) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int mobileNumber) {
		// TODO Auto-generated method stub
		int result=0;
		String deleteSql = "delete from contact where PhoneNo=?";
		try(PreparedStatement pstmt = con.prepareStatement(deleteSql) ){
			
			pstmt.setInt(1, mobileNumber);
		
			result = pstmt.executeUpdate();
			System.out.println("*********************Data Removed****************************************");
			return result;
		} catch (SQLException e) {
			System.err.println("Unable to delete contact!");
			e.printStackTrace();
		}

		
		
		
		return 0;
	}
	
	
	public void displayAll() {
		String sql = "select * from contact";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Name = rs.getString("Name");
				Address = rs.getString("Address");
				phoneNumber = rs.getString("PhoneNo");
				image = rs.getString("image");
				dateOfBirth = rs.getDate("dob").toLocalDate();	
				email = rs.getString("email");
				group = rs.getString("GroupId");
				
			
				System.out.println("Name :"+ Name+ "," +"Address :"+ Address+ "," +"PhoneNumber :"+ phoneNumber+ ","+
						"MobileNumber :"+ phoneNumber+ ","+"Dateofbirth :"+ dateOfBirth+ ","+"email:"+ email+ ","+"group:"+group
						);
			
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
	
	public int updateMobile(String name,int PhoneNo) {
		int result=1;
		String updatesql="update contact set phoneNo = ? where name = ?";
	
		try(PreparedStatement pstmt = con.prepareStatement(updatesql) ){
			
			pstmt.setInt(1, PhoneNo);
			pstmt.setString(2, name);
		
			pstmt.executeUpdate();
			System.out.println("*********************Data Updated****************************************");
			
		} catch (SQLException e) {
			System.err.println("Unable to update contact!");
			e.printStackTrace();
			result=0;
		}

		return result;
	}
	
	
	private <T> boolean writeToFile(List<T> list,String file) {
		boolean isDone = false;
		 File file1 = new File(file);
		try(PrintWriter writer = new PrintWriter(new FileWriter(file1))){
			
			for(T temp : list) {
				writer.println(temp);
			}
			isDone = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDone;
	}
	
	
	public void generateReport(int choice) {
	
		//birthday
		//list of contact by group
		//list by name and email
		//list by name and number
		//count contact in each group display in ascending order
		
		System.out.println("Enter Choice for which you want the report");
		System.out.println("Choice 1- 5 valid :");
		System.out.println("1. Contact having birthday in month of your choice");
		System.out.println("2. List group with count of contacts in it");
		System.out.println("3. Display name and email of contacts");
		System.out.println("4. Display name and phoneNo of contacts");
		System.out.println("5. Contact in each group with data in each group in ascending order");
		
		
		int userChoice=sc.nextInt();
		List<Contact> resultSet=new ArrayList();
		switch(userChoice) {
		case 1:
			System.out.println("Enter month of DOB :");
			int month=sc.nextInt();
			
			String sql = "select * from contact where month(dob) = ?";
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, month);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Name = rs.getString("Name");
					Address = rs.getString("Address");
					phoneNumber = rs.getString("PhoneNo");
					image = rs.getString("image");
					dateOfBirth = rs.getDate("dob").toLocalDate();	
					email = rs.getString("email");
					group = rs.getString("GroupId");
					
					Contact contact = new Contact(Name,Address,Integer.parseInt(phoneNumber),image,dateOfBirth,email,group);
					resultSet.add(contact);

					if(choice==2) {  //write to console
					System.out.println("Name :"+ Name+ "," +"Address :"+ Address+ "," +"PhoneNumber :"+ phoneNumber+ ","+
							"MobileNumber :"+ phoneNumber+ ","+"Dateofbirth :"+ dateOfBirth+ ","+"email:"+ email+ ","+"group:"+group
							);
					}
					
				}	
				
				if(choice==1) {
						writeToFile(resultSet,"birthday.txt");
					
				}
				
				
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			break;
		case 2:
			
			List<String> res=new ArrayList<>();
			String sqlGroup = "select groupid,count(*) as Count from contact group by groupid";
			try(PreparedStatement pstmt = con.prepareStatement(sqlGroup)){
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
				
					group = rs.getString("GroupId");
					int count=rs.getInt("Count");
					
					res.add(group +" "+count);
					if(choice==2) {  //write to console
					System.out.println("Group :"+group+", Count :"+count);
					}
					
				}	
				
				if(choice==1) {
						writeToFile(res,"countGroup.txt");
					
				}
				
				
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}

			break;
		case 3:
			List<String> res1=new ArrayList<>();
			String sqlNameEmail = "select name,email from contact ";
			try(PreparedStatement pstmt = con.prepareStatement(sqlNameEmail)){
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Name = rs.getString("Name");
					
					email = rs.getString("email");
					
					res1.add(Name +" "+email);
					if(choice==2) {  //write to console
					System.out.println("Name :"+ Name+ "," +"email:"+ email);
					}
					
				}	
				
				if(choice==1) {
						writeToFile(res1,"nameEmail.txt");
					
				}
				
				
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			break;
		case 4:
			List<String> res2=new ArrayList<>();
			String sqlNamePhone = "select name,phoneNo from contact ";
			try(PreparedStatement pstmt = con.prepareStatement(sqlNamePhone)){
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Name = rs.getString("Name");
					phoneNumber = rs.getString("PhoneNo");
					res2.add(Name+" "+phoneNumber);
					

					if(choice==2) {  //write to console
					System.out.println("Name :"+ Name+", PhoneNumber :"+ phoneNumber);
					}
					
				}	
				
				if(choice==1) {
						writeToFile(res2,"namePhoneNo.txt");
					
				}
				
				
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			break;

			
			
			
			
		
		case 5:
			List<String> groups=new ArrayList<>();
			String sqltemp = "select groupid,count(*) from contact group by groupid order by count(*)";
			try(PreparedStatement pstmt = con.prepareStatement(sqltemp)){
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					group = rs.getString("GroupId");
					groups.add(group);
					

					
					
				}	
				
				List<String> tempList=new ArrayList();
				String details="";
				for(String groupName: groups) {
					details +=groupName +"\n\n";
					String tempDetails=getDetailsFromGroup(groupName);
					details +=tempDetails +"\n\n\n\n";
					
				}
				
				tempList.add(details);
			
			if(choice==1) {
						writeToFile(tempList,"groupNamePhoneNo.txt");
					
				}
			if(choice==2) {
				System.out.println(details);
			}
				
				
				System.out.println("*************DONE**************");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			
			break;
		default: System.out.println("Wrong Choice");
		
			break;
		
		}
		
		
		
		
		
		
		
		
		
		
		
		resultSet=new ArrayList();
		
	}
	
	
	
	private String getDetailsFromGroup(String groupName) {
		String result="";
		
		String sqlNamePhone = "select name,phoneNo from contact where groupid = ? ";
		try(PreparedStatement pstmt = con.prepareStatement(sqlNamePhone)){
			pstmt.setString(1, groupName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				
				Name = rs.getString("Name");
				phoneNumber = rs.getString("PhoneNo");
				result +=Name+" "+phoneNumber+"\n";
				

				}
				
			}	
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  result;
	}
	
	

}
