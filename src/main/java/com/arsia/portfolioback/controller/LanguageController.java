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

import com.arsia.portfolioback.dto.LanguageDto;
import com.arsia.portfolioback.entity.Language;
import com.arsia.portfolioback.service.LanguageService;

@RestController
@RequestMapping("/portfolio/languages")
@CrossOrigin
public class LanguageController {

	@Autowired
	LanguageService languageService;
	
	@GetMapping
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	//Get one by Id
	@GetMapping("/{id}")
	public Language getById(@PathVariable(required = true) Long id) {
		return languageService.getById(id);
	}
	
	
	//Create
	@PostMapping
	public Language save(@Valid @RequestBody LanguageDto languageDto){
		return languageService.save(languageDto);
	}
	
	//Update
	@PutMapping("/{id}")
	public Language update(@Valid @RequestBody LanguageDto languageDto, @PathVariable(required = true) Long id) {
		return languageService.update(languageDto, id);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id){
		languageService.delete(id);
	}
}
