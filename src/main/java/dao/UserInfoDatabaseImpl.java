package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.SystemException;
import model.UserInfoPojo;

public class UserInfoDatabaseImpl implements UserInfoDao {

	@Override
	public UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo)throws SystemException {

		Connection conn = null;
		try {
			conn = DBUtil.establishConnection();			
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO user_info(first_name, last_name, username, password) VALUES ('"+userInfoPojo.getFirstName()+"','"+userInfoPojo.getLastName()+"','" + userInfoPojo.getUsername()+"', "
					+userInfoPojo.getPassword()+") returning user_id ";
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			userInfoPojo.setUserID(resultSet.getInt(1));
			
			
		   String query1 = "INSERT INTO user_account(user_id) VALUES ('"+userInfoPojo.getUserID()+"') returning bank_account_number";
		   ResultSet resultSet1 = stmt.executeQuery(query1);
		   resultSet1.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return userInfoPojo;
	}	

	@Override
	public UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException {
		Connection conn = null;		
		try {
			conn = DBUtil.establishConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_info WHERE username = '"+ userInfoPojo.getUsername()+"' AND password= '"+ userInfoPojo.getPassword()+"'";
			
			ResultSet resultSet = stmt.executeQuery(query);		
			if (resultSet.next()) { 					
			userInfoPojo.setUserID(resultSet.getInt(3));
			userInfoPojo.setFirstName(resultSet.getString(4));

			}	
		} catch (SQLException e) {
			throw new SystemException();
		}

	return userInfoPojo;
	}


	
}
