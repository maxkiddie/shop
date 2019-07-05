package com.kiddie.user.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiddie.user.pojo.User;
import com.kiddie.vo.PageVo;

public interface UserApi {

	@GetMapping("user/list")
	public PageVo<User> list(@RequestParam("user") User user);
}
