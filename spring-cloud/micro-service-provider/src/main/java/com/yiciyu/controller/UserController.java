package com.yiciyu.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yiciyu.dto.UserDto;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping("/user")
	public List<UserDto> query() {
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto userDto = new UserDto();
		userDto.setUserId(1L);
		userDto.setUsername("admin_1");
		list.add(userDto);
		UserDto userDto2 = new UserDto();
		userDto2.setUserId(2L);
		userDto2.setUsername("admin_2");
		list.add(userDto2);
		logger.info("query======");
		return list;
	}
	
	@GetMapping("/user/{userId}")
	public UserDto getUser(@PathVariable Long userId) {
		UserDto userDto = new UserDto();
		userDto.setUserId(userId);
		userDto.setUsername("admin_" + userId);
		logger.info("getUser======>", userId);
		return userDto;
	}
	
	@PostMapping("/user")
	public boolean add(UserDto userDto) {
		try {
			logger.info("add======>", objectMapper.writeValueAsString(userDto));
		} catch (JsonProcessingException e) {
			logger.error("add|{}", e.getMessage(), e);
		}
		return true;
	}
	
	@PutMapping("/user")
	public boolean update(UserDto userDto) {
		try {
			logger.info("update======>", objectMapper.writeValueAsString(userDto));
		} catch (JsonProcessingException e) {
			logger.error("update|{}", e.getMessage(), e);
		}
		return true;
	}
	
	@DeleteMapping("/user/{userId}")
	public boolean delete(@PathVariable Long userId) {
		logger.info("delete======>", userId);
		return true;
	}

}
