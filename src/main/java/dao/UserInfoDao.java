package dao;

import exceptions.SystemException;
import model.UserInfoPojo;

public interface UserInfoDao {
	
		UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo) throws SystemException; // Create
		
		UserInfoPojo updateUserInfo(UserInfoPojo userInfoPojo) throws SystemException; // Update
		
		void deleteUserInfo(int userID) throws SystemException; // Delete
		
	    UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException; // Read
		
		void exitApplication();
		
		
}
