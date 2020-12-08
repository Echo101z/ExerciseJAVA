package com.example.demo;

public class Loan {
	private double loanAmount;
	private int time;
	private int cScore;

	public Loan() {
		super();
	}

	public Loan(double loanAmount, int time, int cScore) {
		super();
		this.loanAmount = loanAmount;
		this.time = time;
		this.cScore = cScore;
	}

	public double getLoanAmt() {
		return loanAmount;
	}

	public void setLoanAmt(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCibilScore() {
		return cScore;
	}

	public void setCibilScore(int cScore) {
		this.cScore = cScore;
	}

	public double findRateOfInterest() {
		double roi;
		if (this.cScore >= 500) {
			roi = 7.5;
		} else {
			roi = 8.2;
		}
		return roi;
	}

}
