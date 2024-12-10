package com.project.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserInfoMapper {

	@Autowired
	private UserInfoMapper userInfoService;
	
	@Override
	public int insertUser(UserInfo userInfo) {
		return userInfoService.insertUser(userInfo);
	}

	@Override
	public int duplicationUserId(String userId) {
		return userInfoService.duplicationUserId(userId);
	}

	@Override
	public UserInfo loginUserInfo(String userId, String userPw) {
		return userInfoService.loginUserInfo(userId, userPw);
	}

	@Override
	public void lastLoginUpdate(Date lastLogin, String userId) {
		userInfoService.lastLoginUpdate(lastLogin, userId);
	}



}
