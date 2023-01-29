package com.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algalog.domain.model.DeliveryStatus;

public class DeliveryModel {
	
	private Long id;
	private ClientSummaryModel client;
	private RecipientModel recipient;
	private BigDecimal fee;
	private DeliveryStatus status;
	private OffsetDateTime ordererDate;
	private OffsetDateTime finishDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClientSummaryModel getClient() {
		return client;
	}
	public void setClient(ClientSummaryModel client) {
		this.client = client;
	}
	public RecipientModel getRecipient() {
		return recipient;
	}
	public void setRecipient(RecipientModel recipient) {
		this.recipient = recipient;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	public OffsetDateTime getOrdererDate() {
		return ordererDate;
	}
	public void setOrdererDate(OffsetDateTime ordererDate) {
		this.ordererDate = ordererDate;
	}
	public OffsetDateTime getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(OffsetDateTime finishDate) {
		this.finishDate = finishDate;
	}
	
}
