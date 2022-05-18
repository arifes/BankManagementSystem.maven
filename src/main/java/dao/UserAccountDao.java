package dao;

import exceptions.SystemException;
import model.UserAccountPojo;

public interface UserAccountDao {
	
	UserAccountPojo addAccount(UserAccountPojo userAccountPojo) throws SystemException; //Create		
	
	UserAccountPojo addDeposit(UserAccountPojo userAccountPojo) throws SystemException; //Update
	
	UserAccountPojo checkBalance(int bankAccountNumber) throws  SystemException; //Read
	
	UserAccountPojo withdraw(UserAccountPojo userAccountPojo) throws  SystemException; //Update	

}
