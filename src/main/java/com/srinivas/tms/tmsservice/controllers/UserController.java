package com.srinivas.tms.tmsservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.srinivas.tms.tmsservice.models.User;
import com.srinivas.tms.tmsservice.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public void createUser(@RequestBody User user){
		 userRepository.save(user);
	}
	
	@GetMapping(value="/{id}")
	public User getUser(@PathVariable("id") int id){
		return userRepository.getOne(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteUser(@PathVariable("id") Integer id){
		userRepository.deleteById(id);
	}
}
