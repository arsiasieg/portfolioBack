package com.arsia.portfolioback.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.arsia.portfolioback.dto.LanguageDto;
import com.arsia.portfolioback.entity.Language;
import com.arsia.portfolioback.repository.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	LanguageRepository languageRepository;
	
	//Get all
	public List<Language> getAll(){
		return languageRepository.findAll();
	}
	
	
	//Get one by Id
	public Language getById(Long id) {
		return languageRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

	//Create
	public Language save(@Valid LanguageDto languageDto){
		Language language = new Language();
		language.setDescription(languageDto.getDescription());
		language.setIconName(languageDto.getIconName());
		
		return languageRepository.save(language);
	}

	//Update
	public Language update(@Valid LanguageDto languageDto, Long id){
		Language languagetoUpdate = languageRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		languagetoUpdate.setDescription(languageDto.getDescription());
		languagetoUpdate.setIconName(languageDto.getIconName());	
		
		return languageRepository.save(languagetoUpdate);
	}


	//Delete
	public void delete(Long id){
		Boolean exist = languageRepository.existsById(id);
		
		if(!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		languageRepository.deleteById(id);
	}
}
