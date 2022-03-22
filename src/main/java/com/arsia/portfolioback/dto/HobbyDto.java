package com.arsia.portfolioback.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HobbyDto {

	@NotBlank
	@Size(min = 3, max = 100)
	private String iconName;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String description;

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
