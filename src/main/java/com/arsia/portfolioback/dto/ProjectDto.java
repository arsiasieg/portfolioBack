package com.arsia.portfolioback.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjectDto {
	@NotBlank
    private String title;
	
	@NotBlank
    private String image;
	
	@NotBlank
    private String description;
	
	@NotNull
    private List<Long> technologiesId;
	
	@NotBlank
    private String statut;
    private String github;
    private String link;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getTechnologiesId() {
		return technologiesId;
	}
	public void setTechnologiesId(List<Long> technologiesId) {
		this.technologiesId = technologiesId;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
