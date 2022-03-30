package com.arsia.portfolioback.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.arsia.portfolioback.dto.ProjectDto;
import com.arsia.portfolioback.entity.Project;
import com.arsia.portfolioback.entity.Technology;
import com.arsia.portfolioback.repository.ProjectRepository;
import com.arsia.portfolioback.repository.TechnologyRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	//Get all
	public List<Project> getAll(){
		return projectRepository.findAll();
	}
	
	
	//Get one by Id
	public Project getById(Long id) {
		return projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

	//Create
	public Project save(@Valid ProjectDto projectDto){
		Project project = new Project();
		project.setTitle(projectDto.getTitle());
		project.setImage(projectDto.getImage());
		project.setDescription(projectDto.getDescription());
		project.setStatut(projectDto.getStatut());
		project.setGithub(projectDto.getGithub());
		
		//Récupération des technologies
		List<Technology> technologies = new ArrayList<>();
		for(Long technologyId : projectDto.getTechnologiesId()) {
			Technology technology = technologyRepository.findById(technologyId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
			technologies.add(technology);
		}
		
		project.setTechnologies(technologies);
		
		return projectRepository.save(project);
	}

	//Update
	public Project update(@Valid ProjectDto projectDto, Long id){
		Project projectToUpdate = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		projectToUpdate.setTitle(projectDto.getTitle());
		projectToUpdate.setImage(projectDto.getImage());
		projectToUpdate.setDescription(projectDto.getDescription());
		projectToUpdate.setStatut(projectDto.getStatut());
		projectToUpdate.setGithub(projectDto.getGithub());
		
		//Récupération des technologies
		List<Technology> technologies = new ArrayList<>();
		for(Long technologyId : projectDto.getTechnologiesId()) {
			Technology technology = technologyRepository.findById(technologyId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
			technologies.add(technology);
		}
		
		projectToUpdate.setTechnologies(technologies);
		
		return projectRepository.save(projectToUpdate);
	}


	//Delete
	public void delete(Long id){
		Boolean exist = projectRepository.existsById(id);
		
		if(!exist) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		projectRepository.deleteById(id);
	}
}
