package service;

import dao.UserAccountDao;
import dao.UserAccountDatabaseImpl;
import exceptions.SystemException;
import model.UserAccountPojo;

public class UserAccountServiceImpl implements UserAccountService {

UserAccountDao userAccountDao;
	

	public UserAccountServiceImpl() {
		userAccountDao = new UserAccountDatabaseImpl();
	}
	public UserAccountDao getUserAccountDao() {
		return userAccountDao;
	}
	
	public void setUserAccountDao(UserAccountDao userAccountDao) {
		this.userAccountDao = userAccountDao;
	}

	@Override
	public UserAccountPojo addAccount(UserAccountPojo userAccountPojo) throws SystemException{
		return userAccountDao.addAccount(userAccountPojo); 
		
	}

	@Override
	public UserAccountPojo checkBalance(int bankAccountNumber)throws SystemException {
		return userAccountDao.checkBalance(bankAccountNumber);
	}
	@Override
	public UserAccountPojo addDeposit(UserAccountPojo userAccountPojo)throws  SystemException {
		return userAccountDao.addDeposit(userAccountPojo);
	}
	@Override
	public UserAccountPojo withdraw(UserAccountPojo userAccountPojo) throws  SystemException {
		return userAccountDao.withdraw(userAccountPojo);
	}
	

}

