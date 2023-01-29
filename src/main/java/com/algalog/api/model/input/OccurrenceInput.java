package com.algalog.api.model.input;

import jakarta.validation.constraints.NotBlank;

public class OccurrenceInput {
	
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
