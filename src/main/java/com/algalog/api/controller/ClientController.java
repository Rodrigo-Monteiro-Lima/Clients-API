package com.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clients")
	public List<Client> list() {
		return manager.createQuery("from Client", Client.class)
				.getResultList();
	}
}
