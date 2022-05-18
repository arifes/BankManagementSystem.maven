package dao;

import exceptions.SystemException;
import model.UserInfoPojo;

public interface UserInfoDao {
	
		UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo) throws SystemException; // Create
		
	    UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException; // Read
		
		
		
}
