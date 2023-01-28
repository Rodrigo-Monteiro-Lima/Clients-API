package com.algalog.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Recipient {
	
	@Column(name = "recipient_name")
	private String name;
	@Column(name = "recipient_adress")
	private String adress;
	@Column(name = "recipient_number")
	private String number;
	@Column(name = "recipient_complement")
	private String complement;
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
