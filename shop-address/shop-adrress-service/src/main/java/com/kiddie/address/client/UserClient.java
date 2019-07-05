package com.kiddie.address.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.kiddie.address.hystrix.UserHystrix;
import com.kiddie.user.api.UserApi;

@FeignClient(value = "user-service",fallback = UserHystrix.class)
public interface UserClient extends UserApi {

}
