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

import com.arsia.portfolioback.dto.HobbyDto;
import com.arsia.portfolioback.entity.Hobby;
import com.arsia.portfolioback.service.HobbyService;


@RestController
@RequestMapping("/portfolio/hobbies")
@CrossOrigin
public class HobbyController {
	
	@Autowired
	HobbyService hobbyService;
	
	@GetMapping
	public List<Hobby> getAll(){
		return hobbyService.getAll();
	}
	
	//Get one by Id
	@GetMapping("/{id}")
	public Hobby getById(@PathVariable(required = true) Long id) {
		return hobbyService.getById(id);
	}
	
	
	//Create
	@PostMapping
	public Hobby save(@Valid @RequestBody HobbyDto hobbyDto){
		return hobbyService.save(hobbyDto);
	}
	
	//Update
	@PutMapping("/{id}")
	public Hobby update(@Valid @RequestBody HobbyDto hobbyDto, @PathVariable(required = true) Long id) {
		return hobbyService.update(hobbyDto, id);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id){
		hobbyService.delete(id);
	}
}
