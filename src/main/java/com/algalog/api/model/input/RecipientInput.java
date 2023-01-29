package com.algalog.api.model.input;

import jakarta.validation.constraints.NotBlank;

public class RecipientInput {
	
	@NotBlank
	private String name;
	@NotBlank
	private String adress;
	@NotBlank
	private String number;
	@NotBlank
	private String complement;
	@NotBlank
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
