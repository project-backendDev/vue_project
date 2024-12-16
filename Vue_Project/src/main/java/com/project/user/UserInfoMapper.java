package com.project.user;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
	
	/*
	 * 회원가입
	 */
	public int insertUser(UserInfo userInfo);
	
	/*
	 * 회원 전체조회
	 */
	public List<UserInfo> getAllUserList();
	
	/*
	 * 단일 회원조회
	 */
	public UserInfo getUserListByUserId(String userId);

	/*
	 * 사이트에서 회원가입 시 아이디 중복검사
	 */
	public int duplicationUserId(String userId);
	
	/*
	 * 사이트에서 로그인 시 아이디와 비밀번호 체크
	 */
	public UserInfo loginUserInfo(String userId, String userPw);
	
	/*
	 * 로그인 시 마지막 로그인 날짜 업데이트
	 */
	public void lastLoginUpdate(Date lastLogin, String userId);
	
}
