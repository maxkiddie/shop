package com.kiddie.address.hystrix;

import org.springframework.stereotype.Component;

import com.kiddie.address.client.UserClient;
import com.kiddie.user.pojo.User;
import com.kiddie.vo.PageVo;

@Component
public class UserHystrix implements UserClient {

	@Override
	public PageVo<User> list(User user) {
		return new PageVo<User>(1, 100);
	}

}
