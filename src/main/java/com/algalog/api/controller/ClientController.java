package com.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Client;
import com.algalog.domain.model.service.CrudClient;
import com.algalog.domain.repository.ClientRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRespository;
	@Autowired
	private CrudClient crudClient;
	
	@GetMapping
	public List<Client> list() {
		return clientRespository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> search(@PathVariable Long clientId) {
		return clientRespository.findById(clientId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client add(@Valid @RequestBody Client client) {
		return crudClient.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@PathVariable Long clientId, @Valid @RequestBody Client client) {
		if (!clientRespository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = crudClient.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId) {
		if (!clientRespository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		crudClient.delete(clientId);
		
		return ResponseEntity.noContent().build();
	}
}
