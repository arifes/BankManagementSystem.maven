package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import exceptions.SystemException;
import model.UserAccountPojo;

public class UserAccountDatabaseImpl implements UserAccountDao {

	@Override
	public UserAccountPojo addAccount(UserAccountPojo userAccountPojo) throws SystemException {
		Connection conn = null;
		try {
		conn = DBUtil.establishConnection();
		Statement stmt = conn.createStatement();
		String query = "INSERT INTO user_account(account_type, balance) VALUES ('"+userAccountPojo.getAccountType()+"', "+userAccountPojo.getBalance()+") returning bank_account_number";
	    ResultSet resultSet = stmt.executeQuery(query);
	    resultSet.next();
	    userAccountPojo.setBankAccountNumber(resultSet.getInt(1));
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return userAccountPojo;
	}
	

	@Override	
	public UserAccountPojo checkBalance(int bankAccountNumber) throws SystemException {
		Connection conn = null;
		UserAccountPojo userAccountPojo = null;
		try {
			conn = DBUtil.establishConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_account WHERE bank_account_number="+bankAccountNumber;
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				userAccountPojo = new UserAccountPojo(resultSet.getInt(1),resultSet.getDouble(2), resultSet.getString(3),resultSet.getInt(4));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return userAccountPojo;
	}

	@Override	
	public UserAccountPojo addDeposit(UserAccountPojo userAccountPojo) throws  SystemException {
		Connection conn = null;
		try {
		conn = DBUtil.establishConnection();
		Statement stmt = conn.createStatement();
		String query = "UPDATE user_account SET balance="+userAccountPojo.getBalance()+ "WHERE bank_account_number="+userAccountPojo.getBankAccountNumber();
		int rowsAffected = stmt.executeUpdate(query); 		 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return userAccountPojo;
	}

	@Override
	public UserAccountPojo withdraw(UserAccountPojo userAccountPojo)throws SystemException {
		Connection conn = null;
		try {
		conn = DBUtil.establishConnection();
		Statement stmt = conn.createStatement();
		String query = "UPDATE user_account SET balance="+userAccountPojo.getBalance()+ "WHERE bank_account_number="+userAccountPojo.getBankAccountNumber();
		int rowAffected = stmt.executeUpdate(query);		
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return userAccountPojo;
	}





	



	
	
	
	

}
