package com.algalog.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Recipient {
	
	@NotBlank
	@Column(name = "recipient_name")
	private String name;
	@NotBlank
	@Column(name = "recipient_adress")
	private String adress;
	@NotBlank
	@Column(name = "recipient_number")
	private String number;
	@NotBlank
	@Column(name = "recipient_complement")
	private String complement;
	@NotBlank
	@Column(name = "recipient_neighborhood")
	private String neighborhood;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	
}
