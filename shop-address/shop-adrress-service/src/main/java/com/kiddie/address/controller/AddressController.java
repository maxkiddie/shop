package com.kiddie.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddie.address.pojo.Address;
import com.kiddie.address.service.AddressService;
import com.kiddie.vo.PageVo;

@RestController("address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping
	public ResponseEntity<Address> save(Address address) {
		return ResponseEntity.ok(addressService.save(address));
	}

	@GetMapping("list")
	public ResponseEntity<PageVo<Address>> list(Address address) {
		return ResponseEntity.ok(addressService.list(address));
	}
}
