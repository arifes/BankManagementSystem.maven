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
//		logger.info("addUserInfo() in Service");
	//	UserInfoPojo returnUserInfoPojo = this.userInfoDao.addUserInfo(userInfoPojo);
//		logger.info("Exiting addUserInfo()");
		return userInfoDao.addUserInfo(userInfoPojo);
		
	}

	@Override
	public UserInfoPojo updateUserInfo(UserInfoPojo userInfoPojo) throws SystemException {
//		logger.info("Entered updateUserInfo() in service");
//		UserInfoPojo returnUserInfoPojo = this.userInfoDao.updateUserInfo(userInfoPojo);
//		logger.info("Exited updateUserInfo() in service");
		return userInfoDao.updateUserInfo(userInfoPojo);
	}

	@Override
	public void deleteUserInfo(int userID) throws SystemException {
		userInfoDao.deleteUserInfo(userID);
		
	}
	@Override
	public UserInfoPojo validateUser(UserInfoPojo userInfoPojo) throws SystemException {
	   UserInfoPojo returnUserInfoPojo = this.userInfoDao.validateUser(userInfoPojo);
	   return returnUserInfoPojo;
		//return userInfoDao.validateUser(userInfoPojo);
		
	}

/*	@Override
	public void exitApplication() {
//		logger.info("Entered exitApplication() in service");
		userInfoDao.exitApplication();
//		logger.info("Exited exitApplication() in service");
		
	}
*/
}
