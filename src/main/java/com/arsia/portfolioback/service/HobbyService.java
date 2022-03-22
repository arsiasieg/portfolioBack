package com.arsia.portfolioback.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.arsia.portfolioback.dto.HobbyDto;
import com.arsia.portfolioback.entity.Hobby;
import com.arsia.portfolioback.repository.HobbyRepository;

@Service
public class HobbyService {
	@Autowired
	HobbyRepository hobbyRepository;
	
	//Get all
	public List<Hobby> getAll(){
		return hobbyRepository.findAll();
	}
	
	
	//Get one by Id
	public Hobby getById(Long id) {
		return hobbyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

	//Create
	public Hobby save(@Valid HobbyDto hobbyDto){
		Hobby hobby = new Hobby();
		hobby.setDescription(hobbyDto.getDescription());
		hobby.setIconName(hobbyDto.getIconName());
		
		return hobbyRepository.save(hobby);
	}

	//Update
	public Hobby update(@Valid HobbyDto hobbyDto, Long id){
		Hobby hobbytoupdate = hobbyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		hobbytoupdate.setDescription(hobbyDto.getDescription());
		hobbytoupdate.setIconName(hobbyDto.getIconName());	
		
		return hobbyRepository.save(hobbytoupdate);
	}


	//Delete
	public void delete(Long id){
		Boolean exist = hobbyRepository.existsById(id);
		
		if(!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		hobbyRepository.deleteById(id);
	}
}
