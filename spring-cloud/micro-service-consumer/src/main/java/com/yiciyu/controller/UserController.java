package com.yiciyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yiciyu.dto.UserDto;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate template;
	
//	private String urlPrefix = "http://192.168.23.66:8820";
	private String urlPrefix = "http://MICRO-SERVICE-PROVIDER";
	
	@SuppressWarnings("unchecked")
	@GetMapping("/user")
	public List<UserDto> query() {
		return template.getForObject(urlPrefix + "/user", List.class);
	}
	
	@GetMapping("/user/{userId}")
	public UserDto getUser(@PathVariable Long userId) {
		return template.getForObject(urlPrefix + "/user/" + userId, UserDto.class);
	}
	
	@PostMapping("/user")
	public boolean add(UserDto userDto) {
		return template.postForObject(urlPrefix + "/user", userDto, Boolean.class);
	}
	
//	@PutMapping("/user")
//	public boolean update(UserDto userDto) {
//		return template.put(urlPrefix + "/user", userDto, Boolean.class);
//	}
//	
//	@DeleteMapping("/user/{userId}")
//	public boolean delete(@PathVariable Long userId) {
//		return template.delete;
//	}

}
