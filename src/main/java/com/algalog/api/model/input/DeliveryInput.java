package com.algalog.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class DeliveryInput {
	
	@Valid
	@NotNull
	private ClientIdInput client;
	@Valid
	@NotNull
	private RecipientInput recipient;
}
