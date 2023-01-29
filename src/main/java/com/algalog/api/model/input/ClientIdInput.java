package com.algalog.api.model.input;

import jakarta.validation.constraints.NotNull;

public class ClientIdInput {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
