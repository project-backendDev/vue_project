package com.project.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserInfoMapper {

	@Autowired
	private UserInfoMapper userInfoService;
	
	/*
	 * 회원가입
	 */
	@Override
	public int insertUser(UserInfo userInfo) {
		return userInfoService.insertUser(userInfo);
	}

	/*
	 * 아이디 중복체크
	 */
	@Override
	public int duplicationUserId(String userId) {
		return userInfoService.duplicationUserId(userId);
	}

	/*
	 * 로그인 시 계정정보 체크
	 */
	@Override
	public UserInfo loginUserInfo(String userId, String userPw) {
		return userInfoService.loginUserInfo(userId, userPw);
	}

	/*
	 * 로그인 시 마지막 로그인 날짜 업데이트
	 */
	@Override
	public void lastLoginUpdate(Date lastLogin, String userId) {
		userInfoService.lastLoginUpdate(lastLogin, userId);
	}



}
