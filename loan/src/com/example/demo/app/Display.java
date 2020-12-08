package com.example.demo.app;

import com.example.demo.HousingLoan;

public class Display {
	public void print(HousingLoan houseLoan) {
		System.out.println("Amount: " + houseLoan.getLoanAmt());
		System.out.println("Time: " + houseLoan.getTime());
		System.out.println("Rate: " + houseLoan.getRate());
		System.out.println("cScore: " + houseLoan.getCibilScore());
		System.out.println("Property Type:" + houseLoan.getPropertyType());
		System.out.println("Simple Interest:" + houseLoan.findRateOfInterest());
		System.out.println("=====================");
	}

	public void printHouseLoan(HousingLoan[] houseLoans) {
		// TODO Auto-generated method stub
		for (HousingLoan houseLoan : houseLoans) {
			print(houseLoan);
		}
	}
}
