package service;

import dao.UserInfoDao;
import dao.UserInfoDatabaseImpl;
import exceptions.SystemException;
import model.UserInfoPojo;

public class UserInfoServiceImpl implements UserInfoService {
	
	UserInfoDao userInfoDao;
	
	public UserInfoServiceImpl() {
		userInfoDao = new UserInfoDatabaseImpl();
	
	}
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	
    @Override
	public UserInfoPojo addUserInfo(UserInfoPojo userInfoPojo) throws SystemException {				
		return userInfoDao.addUserInfo(userInfoPojo);
		
	}

	@Override
	public UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException {
	   UserInfoPojo returnUserInfoPojo = this.userInfoDao.validateUser(userInfoPojo);
	   return returnUserInfoPojo;
		
		
	}

}
