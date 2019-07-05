package com.kiddie.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kiddie.address.client.UserClient;
import com.kiddie.address.mapper.AddressMapper;
import com.kiddie.address.pojo.Address;
import com.kiddie.user.pojo.User;
import com.kiddie.vo.PageVo;

@Service
public class AddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private UserClient userClient;

	public Address save(Address address) {
		addressMapper.insertSelective(address);
		return address;
	}

	public PageVo<Address> list(Address address) {
		PageVo<Address> vo = new PageVo<Address>(1, 10);
		Page<Address> pageBean = PageHelper.startPage(vo.getPage(), vo.getSize(), "id desc");
		List<Address> list = addressMapper.select(address);
		vo.setTotal(pageBean.getTotal());
		vo.setList(list);
		PageVo<User> entity = userClient.list(new User());
		System.out.println(entity);
		return vo;
	}
}
