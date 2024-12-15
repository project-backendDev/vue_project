package com.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 회원가입 메소드
	 * @param userInfo
	 */
	@PostMapping(value = "/user/regist")
	public void userRegist(@RequestBody UserInfo userInfo) {
	
		System.out.println("[S] RegistController");
		userInfoService.insertUser(userInfo);
		System.out.println("[E] RegistController");
	}
}
