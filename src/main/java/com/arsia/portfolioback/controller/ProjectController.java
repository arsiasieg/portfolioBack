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

import com.arsia.portfolioback.dto.ProjectDto;
import com.arsia.portfolioback.entity.Project;
import com.arsia.portfolioback.service.ProjectService;

@RestController
@RequestMapping("/portfolio/projects")
@CrossOrigin
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping
	public List<Project> getAll(){
		return projectService.getAll();
	}
	
	//Get one by Id
	@GetMapping("/{id}")
	public Project getById(@PathVariable(required = true) Long id) {
		return projectService.getById(id);
	}
	
	
	//Create
	@PostMapping
	public Project save(@Valid @RequestBody ProjectDto projectDto){
		return projectService.save(projectDto);
	}
	
	//Update
	@PutMapping("/{id}")
	public Project update(@Valid @RequestBody ProjectDto projectDto, @PathVariable(required = true) Long id) {
		return projectService.update(projectDto, id);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id){
		projectService.delete(id);
	}
}
