package com.example.demo.model;

public class SavingsAccount extends BankAccount {

	private String nominee;

	public SavingsAccount(long accountNumber, String accountHolderName, double currentBalance, String nominee) {
		super(accountNumber, accountHolderName, currentBalance);
		this.nominee = nominee;
	}

	@Override
	public double deposit(double amount) {
		double clearBalance=0;
		double currentBalance = getCurrentBalance();
		if(amount>100000)
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
		if((currentBalance - amount)<5000)
		{
			System.out.println("Cannot withdraw as balance becomes less than 5000");
		}
		else
		{
		 clearBalance = currentBalance - amount;
		 setCurrentBalance(clearBalance);
		}
		
		return clearBalance;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
}
