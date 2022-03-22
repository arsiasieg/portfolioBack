package com.arsia.portfolioback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arsia.portfolioback.dto.UserDto;
import com.arsia.portfolioback.entity.User;
import com.arsia.portfolioback.service.UserService;


@RestController
@RequestMapping("/portfolio/users")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();
	}
	
	//Get one by Id
	@GetMapping("/{id}")
	public User getById(@PathVariable(required = true) Long id) {
		return userService.getById(id);
	}
	
	
	//Create
	@PostMapping
	public User save(@Valid @RequestBody UserDto userDto){
		return userService.save(userDto);
	}
	
	//Update
	@PutMapping("/{id}")
	public User update(@Valid @RequestBody UserDto userDto, @PathVariable(required = true) Long id) {
		return userService.update(userDto, id);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id){
		userService.delete(id);
	}
}
