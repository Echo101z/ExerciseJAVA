package com.example.demo.services;
import com.example.demo.*;

public class BookService {
	
	
	public BookService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		public double calculateDiscount(Book book) {
		 double discount=0;
			if(book.getPrice()<1000) {
				discount=100;
			}else {
				discount=50;
			}
			return discount; 	 	 
	}
	
	public double calculateSalary(Book book,String customerType) {
		double discount=0;
	if(customerType.equals("Retail")) {
		discount=150;
	}else {
		discount=100;
	}
		return discount;
	}
	

	
}
