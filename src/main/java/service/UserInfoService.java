package service;

import exceptions.SystemException;
import model.UserInfoPojo;

public interface UserInfoService {

    UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo) throws SystemException; //Create
		
	UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException; // Read
	
	
}
