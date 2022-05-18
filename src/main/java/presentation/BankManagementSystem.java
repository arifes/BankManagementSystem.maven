package presentation;

import java.util.Scanner;

import exceptions.SystemException;
import model.UserAccountPojo;
import model.UserInfoPojo;
import service.UserAccountService;
import service.UserAccountServiceImpl;
import service.UserInfoService;
import service.UserInfoServiceImpl;

public class BankManagementSystem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		UserInfoService userInfoService = new UserInfoServiceImpl();
		UserAccountService userAccountService = new UserAccountServiceImpl();
		String cont = "yes";
		while (cont == "yes") {
			System.out.println("----------------------------------------------");
			System.out.println(" ** WELCOME TO EES BANK **");
			System.out.println("----------------------------------------------");
			System.out.println("1. New Account Registration");
			System.out.println("2. Existing User Login  ");
			System.out.println("3. Exit");
			System.out.println("----------------------------------------------");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				UserInfoPojo newUserInfoPojo = new UserInfoPojo();
				System.out.println("----------------------------------------------");
				System.out.println("Please enter your first name: ");
				scan.nextLine();
				newUserInfoPojo.setFirstName(scan.nextLine());
				System.out.println("Please enter your last name: ");
				newUserInfoPojo.setLastName(scan.nextLine());
				System.out.println("Please enter a  username: ");
				newUserInfoPojo.setUsername(scan.nextLine());
				System.out.println("Please create a  password: ");
				newUserInfoPojo.setPassword(scan.nextLine());
				System.out.println("----------------------------------------------");
				UserInfoPojo userInfoPojo = null;
				try {
					userInfoPojo = userInfoService.addUserInfo(newUserInfoPojo);
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("** New user registered ** ");
				System.out.println("User ID is " + userInfoPojo.getUserID());
				System.out.println("----------------------------------------------");
				//System.out.println("Would you like to return to main menu? (yes/no)");
				//cont = scan.nextLine();
				break;
			case 2:
				UserInfoPojo userInfoLogPojo = new UserInfoPojo();
				System.out.println("Please enter account username: ");
				scan.nextLine();
				userInfoLogPojo.setUsername(scan.nextLine());
				System.out.println("Enter user password: ");
				userInfoLogPojo.setPassword(scan.nextLine());

				UserInfoPojo returnedUserInfoLoginPojo = null;
				try {
					returnedUserInfoLoginPojo = userInfoService.validateUser(userInfoLogPojo);

				} catch (SystemException e) {
					System.out.println("Error occured. Please try again later.");
					break;
				}
				int userID = returnedUserInfoLoginPojo.getUserID();
				String usernameOutput = returnedUserInfoLoginPojo.getFirstName();
				if (userID == 0) {
					System.out.println("----------------------------------------------");
					System.out.println("User account not found. Please try again");
					System.out.println("----------------------------------------------");
					break;
				}				
				else {
					int opt = 0;
					while (opt != 5) {
						System.out.println("----------------------------------------------");
						System.out.println("Welcome back " + usernameOutput + ", USERID: " + userID);
						System.out.println("----------------------------------------------");
						System.out.println("1. Add new banking account");
						System.out.println("2. Deposit");
						System.out.println("3. Withdraw");
						System.out.println("4. Check balance");
						System.out.println("5. Exit");
						System.out.println("Please enter an option: ");
						opt = scan.nextInt();
						switch (opt) {
						case 1:
							UserAccountPojo newUserAccountPojo = new UserAccountPojo();
							System.out.println("----------------------------------------------");
							System.out.println("Please enter account type: (Checking/Saving)");
							scan.nextLine();
							newUserAccountPojo.setAccountType(scan.nextLine());
							UserAccountPojo userAccountPojo = null;
							try {
								userAccountPojo = userAccountService.addAccount(newUserAccountPojo);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("----------------------------------------------");
							System.out.println("New account opened");
							System.out.println("The bank account Number is " + userAccountPojo.getBankAccountNumber());
							break;
						case 2:
							System.out.println("Please enter bank account to deposit into: ");
							int depositBankAccount = scan.nextInt();
							UserAccountPojo depositUserAccountPojo = null;
							try {
								depositUserAccountPojo = userAccountService.checkBalance(depositBankAccount);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							if (depositUserAccountPojo == null) {
								System.out.println("Error. Bank Account Number does not exist");
								break;
							} else {
								System.out.println("--------------------------------");
								System.out.println("Bank Account UserID: " + depositUserAccountPojo.getUserID());
								System.out.println("Bank Account Number: " + depositUserAccountPojo.getBankAccountNumber());
								System.out.println("Bank Account Type: " + depositUserAccountPojo.getAccountType());
								System.out.println("Account balance is $" + depositUserAccountPojo.getBalance());
								System.out.println("---------------------------------");
								System.out.println("Please enter deposit amount: ");
								double amountToDeposit = scan.nextDouble();
								double balance = depositUserAccountPojo.getBalance();
								double newBalance = balance + amountToDeposit;
								depositUserAccountPojo.setBalance(newBalance);
								System.out.println("New balance:" + depositUserAccountPojo.getBalance());
								try {
									userAccountService.addDeposit(depositUserAccountPojo);
								} catch (SystemException e) {
									System.out.println(e.getMessage());
									break;
								}
								System.out.println("Amount deposited");

							}break;
						case 3:
							System.out.println("Please enter bank account number to withdraw from: ");
							int withdrawBankAccount = scan.nextInt();
							UserAccountPojo withdrawUserAccountPojo = null;
							try {withdrawUserAccountPojo = userAccountService.checkBalance(withdrawBankAccount);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							if (withdrawUserAccountPojo == null) {
								System.out.println("Error. Bank Account Number does not exist");
								break;
							} else {
								System.out.println("--------------------------------");
								System.out.println("Bank Account UserID: " + withdrawUserAccountPojo.getUserID());
								System.out.println("Bank Account Number: " + withdrawUserAccountPojo.getBankAccountNumber());
								System.out.println("Bank Account Type: " + withdrawUserAccountPojo.getAccountType());
								System.out.println("Account balance is $" + withdrawUserAccountPojo.getBalance());
								System.out.println("---------------------------------");
								System.out.println("Please enter withdraw amount: ");
								double amountToWithdraw = scan.nextDouble();
								double balance = withdrawUserAccountPojo.getBalance();
								if (balance < amountToWithdraw) {
									System.out.println("Error. Insufficent funds");
									break;
								}
								else {
									double newBalance = balance - amountToWithdraw;
									withdrawUserAccountPojo.setBalance(newBalance);
									try {
										userAccountService.withdraw(withdrawUserAccountPojo);

									} catch (SystemException e) {
										System.out.println(e.getMessage());
										break;
									}
								} 
								System.out.println("Amount withdrawn from account");
							 }						
							break;
						case 4:
							System.out.println("Please enter bank account number: ");
							int checkBankAccount = scan.nextInt();
							UserAccountPojo balanceUserAccountPojo = null;
							try {
								balanceUserAccountPojo = userAccountService.checkBalance(checkBankAccount);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							if (balanceUserAccountPojo == null) {
								System.out.print("Error!");
								System.out.print("Bank account number does not exist");
							} else {
								System.out.println("--------------------------------------");
								System.out.println("Balance is " + balanceUserAccountPojo.getBalance());
							}
							break;
						case 5:
							
						}
					}
				}
			case 3:
				System.out.println("--------------------------------------");
				System.out.println("Thank you for your service");
				System.out.println("--------------------------------------");
				System.exit(0);
			default:
			}
		}
	}

}
