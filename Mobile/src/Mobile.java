
class Mobile{
	static String company="XYZ";
	String name;
	String plan;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPlan() {
		return plan;
	}


	public void setPlan(String plan) {
		this.plan = plan;
	}


	public long getNumber() {
		return number;
	}


	public void setNumber(long number) {
		this.number = number;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	long number;
	int amount;
	
	Mobile(String name,long number,String plan,int amount){
		this.name=name;
		this.plan=plan;
		this.amount=amount;
		this.number=number;
		
	}
	
	
	public String getBill() {
		return company+" bill of \n "+this.name +" customer \n Number "+this.number+" is "+this.amount +" for "+this.plan;
	}
	
	
	
	
	
	
	
}