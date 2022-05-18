package service;

import exceptions.SystemException;
import model.UserAccountPojo;

public interface UserAccountService {
		
		
		 UserAccountPojo addAccount(UserAccountPojo userAccountPojo) throws SystemException;
			
			UserAccountPojo checkBalance(int bankAccountNumber) throws SystemException;
			
			UserAccountPojo addDeposit(UserAccountPojo userAccountPojo)throws SystemException;
			
			UserAccountPojo withdraw(UserAccountPojo userAccountPojo)throws SystemException;
			


	}

	

	

	

	

