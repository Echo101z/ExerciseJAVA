package com.example.demo;
import com.example.demo.model.BankAccount;
import com.example.demo.model.BuisnessAccount;
import com.example.demo.model.SavingsAccount;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// supertype=subtype
		BankAccount account = new SavingsAccount(123, "abc", 1500, "xyz");
		account.deposit(1500);
		account.deposit(17000);
		account.deposit(1000000);
		account.withdraw(16000);
	
		System.out.println("Balance:" + account.getCurrentBalance());

	}
}
