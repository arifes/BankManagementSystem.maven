package model;

public class UserAccountPojo {	
	private int userID;	
	private double balance;
	private String accountType;
	private int bankAccountNumber;

	public UserAccountPojo() {
		
	}
	public UserAccountPojo( int userID, double balance, String accountType,int bankAccountNumber) {
		super();		
		this.userID = userID;
		this.balance = balance;
		this.accountType = accountType;
		this.bankAccountNumber = bankAccountNumber;
	}
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "UserAccountPojo [userID=" + userID + ", balance=" + balance + ", accountType=" + accountType
				+ ", bankAccountNumber=" + bankAccountNumber + "]";
	}
	

	
}	