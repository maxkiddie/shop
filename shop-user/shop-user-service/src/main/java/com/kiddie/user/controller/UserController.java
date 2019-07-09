package com.kiddie.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddie.user.pojo.User;
import com.kiddie.user.service.UserService;
import com.kiddie.vo.PageVo;

@RestController("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${server.port}")
	private String port;

	@PostMapping
	public ResponseEntity<User> save(User user) {
		return ResponseEntity.ok(userService.save(user));
	}

	@GetMapping
	public ResponseEntity<PageVo<User>> list(User user) {
		System.out.println("访问了list,port=" + port);
		return ResponseEntity.ok(userService.list(user));
	}
}
