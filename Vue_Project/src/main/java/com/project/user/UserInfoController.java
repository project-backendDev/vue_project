package com.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	
	@PostMapping(value = "/user/regist")
	public ResponseEntity<Integer> userRegist(@RequestBody UserInfo userInfo) {
	
		int result = userInfoService.insertUser(userInfo);
		
		if (result > 0) {
			return ResponseEntity.ok(result);
		} 

		return null;
	}
}
