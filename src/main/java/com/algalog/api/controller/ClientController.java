package com.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Client;
import com.algalog.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRespository;
	
	@GetMapping("/clients")
	public List<Client> list() {
		return clientRespository.findAll();
	}
}
