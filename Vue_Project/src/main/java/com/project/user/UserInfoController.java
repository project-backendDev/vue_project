package com.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<String> userRegist(@RequestBody UserInfo userInfo) {
	
		System.out.println("[S] RegistController");
		userInfoService.insertUser(userInfo);
		System.out.println("[E] RegistController");

		// status 201 -> Created를 의미하며 클라이언트의 요청이 성공적으로 처리되었고, 그 결과 새로운 리소스가 생성되었음을 나타냄
		return ResponseEntity.status(201).body("회원가입이 완료되었습니다.");
	}

	/*
	 * 회원 전체조회
	 */
	@GetMapping(value = "/user/getUserList")
	public ResponseEntity<List<UserInfo>> getAllUserList() {
		System.out.println("[S] getAllUserList");
		
		return ResponseEntity.ok(userInfoService.getAllUserList());
	}
	
	/*
	 * 단일 회원조회
	 */
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<UserInfo> getUserListByUserId(@PathVariable String userId) {
		System.out.println(userId);
		System.out.println("[S] getUserListByUserId");
		
		UserInfo user = userInfoService.getUserListByUserId(userId);
		System.out.println(user.toString());
		
		return ResponseEntity.ok(userInfoService.getUserListByUserId(userId));
	}
}
