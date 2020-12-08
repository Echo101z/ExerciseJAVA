package com.example.demo.model;

public class BuisnessAccount extends BankAccount {
 private String buisnessType;

	public BuisnessAccount(long accountNumber, String accountHolderName, double currentBalance, String buisnessType) {
	super(accountNumber, accountHolderName, currentBalance);
	this.buisnessType = buisnessType;
}

	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		double clearBalance=0;
		double currentBalance = getCurrentBalance();
		if(amount>=1000000)
		{
			System.out.println("Cannot Deposit as it exceeds 100000");
		}
		else
		{
		 clearBalance = currentBalance + amount;
		setCurrentBalance(clearBalance);
		}
		return clearBalance;
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		double currentBalance = getCurrentBalance();
		double clearBalance = 0;
		if((currentBalance - amount)<25000)
		{
			System.out.println("Cannot withdraw as balance becomes less than 5000");
		}
		else
		{
		 clearBalance = currentBalance - amount;
		}
		
		return clearBalance;
	}

}
