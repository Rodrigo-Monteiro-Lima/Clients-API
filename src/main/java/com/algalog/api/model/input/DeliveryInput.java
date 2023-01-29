package com.algalog.api.model.input;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class DeliveryInput {
	
	@Valid
	@NotNull
	private ClientIdInput client;
	@Valid
	@NotNull
	private RecipientInput recipient;
	@NotNull
	private BigDecimal fee;
	
	public ClientIdInput getClient() {
		return client;
	}
	public void setClient(ClientIdInput client) {
		this.client = client;
	}
	public RecipientInput getRecipient() {
		return recipient;
	}
	public void setRecipient(RecipientInput recipient) {
		this.recipient = recipient;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
}
