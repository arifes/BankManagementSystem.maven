package service;

import exceptions.SystemException;
import model.UserInfoPojo;

public interface UserInfoService {

    UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo) throws SystemException; //Create
	
	UserInfoPojo updateUserInfo(UserInfoPojo userInfoPojo) throws SystemException; // Update
	
	void deleteUserInfo(int userID) throws SystemException; // Delete
	
	UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException; // Read
	
	
}
