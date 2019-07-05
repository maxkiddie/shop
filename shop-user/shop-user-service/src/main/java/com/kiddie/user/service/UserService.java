package com.kiddie.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kiddie.user.mapper.UserMapper;
import com.kiddie.user.pojo.User;
import com.kiddie.vo.PageVo;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User save(User user) {
		user.setRegTime(new Date());
		userMapper.insertSelective(user);
		return user;
	}

	public PageVo<User> list(User user) {
		PageVo<User> vo = new PageVo<User>(1, 10);
		Page<User> pageBean = PageHelper.startPage(vo.getPage(), vo.getSize(), "id desc");
		List<User> list = userMapper.select(user);
		vo.setTotal(pageBean.getTotal());
		vo.setList(list);
		return vo;
	}
}
