package com.example.demo.app;

import com.example.demo.HousingLoan;

public class Application {
	public static void main(String[] args) {
		HousingLoan house1 = new HousingLoan(7000, 2, 300, "Duplex");
	
		HousingLoan[] list1 = new HousingLoan[2];
		HousingLoan[0]=house1;
		Display display = new Display();
		display.printHouseLoan(list1);
	}
}