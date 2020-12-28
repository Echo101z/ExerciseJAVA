package com.project.services;
import com.project.model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.project.util.DbConnectionUtil;
public class CsvRead {

	 public static final String delimiter = ",";
	 public static final String filename="./data.csv";
	 static DaoImplementation dao;
	 
	 public CsvRead() {
		dao=new DaoImplementation();
	 }
	 
	   public void readData() {
	      try {
	         File file = new File(filename);
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	      		List<Contact> tempList=new ArrayList<>();
	         while((line = br.readLine()) != null) {
	            String[] temp = line.split(delimiter);
	            Contact tempContact=new Contact(temp[0],temp[1],Integer.parseInt(temp[2]),temp[3],LocalDate.parse(temp[4]),temp[5],temp[6]);
	            tempList.add(tempContact);
	            
	            System.out.println();
	         }
	         for(Contact tempcontact: tempList) {
	        	 dao.add(tempcontact);
	         }
	         System.out.println("********************All Contacts Added****************************");
	         
	         br.close();
	         } catch(IOException io) {
	            io.printStackTrace();
	         }
	   }
	
	
	
}
