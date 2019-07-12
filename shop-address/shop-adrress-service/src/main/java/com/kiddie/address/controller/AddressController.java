package com.kiddie.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiddie.address.pojo.Address;
import com.kiddie.address.service.AddressService;
import com.kiddie.vo.PageVo;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("list")
	public ResponseEntity<PageVo<Address>> list(Address address) {
		return ResponseEntity.ok(addressService.list(address));
	}

	@PostMapping
	public ResponseEntity<Address> save(Address address) {
		return ResponseEntity.ok(addressService.save(address));
	}

}
