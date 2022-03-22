package com.arsia.portfolioback.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.arsia.portfolioback.dto.UserDto;
import com.arsia.portfolioback.entity.User;
import com.arsia.portfolioback.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//Get all
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	
	//Get one by Id
	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

	//Create
	public User save(@Valid UserDto userDto){
		User user = new User();
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setPhone(userDto.getPhone());
		user.setDescription(userDto.getDescription());
		
		return userRepository.save(user);
	}

	//Update
	public User update(@Valid UserDto userDto, Long id){
		User usertoUpdate = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		usertoUpdate.setFirstname(userDto.getFirstname());
		usertoUpdate.setLastname(userDto.getLastname());
		usertoUpdate.setEmail(userDto.getEmail());
		usertoUpdate.setAddress(userDto.getAddress());
		usertoUpdate.setPhone(userDto.getPhone());
		usertoUpdate.setDescription(userDto.getDescription());
		return userRepository.save(usertoUpdate);
	}


	//Delete
	public void delete(Long id){
		Boolean exist = userRepository.existsById(id);
		
		if(!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		userRepository.deleteById(id);
	}

}
