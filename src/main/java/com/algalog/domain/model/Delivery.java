package com.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.algalog.domain.ValidationGroups;
import com.algalog.domain.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne	
	private Client client;
	@Embedded
	private Recipient recipient;
	private BigDecimal fee;
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occurrences = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status ;
	private OffsetDateTime ordererDate;
	private OffsetDateTime finishDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
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
	public List<Occurrence> getOccurrences() {
		return occurrences;
	}
	public void setOccurrences(List<Occurrence> occurrences) {
		this.occurrences = occurrences;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(id, other.id);
	}
	public Occurrence addOccurence(String description) {
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setRegistrationDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOccurrences().add(occurrence);
		
		return occurrence;
	}
	public void conclude() {
		
		if (!canBeFinished()) {
			throw new BusinessException("Delivery cannot be completed");
		}
		
		setStatus(DeliveryStatus.FINISHED);
		setFinishDate(OffsetDateTime.now());		
	}
	
	public boolean canBeFinished() {
		return DeliveryStatus.PENDING.equals(getStatus());
	}

}
