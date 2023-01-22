package com.algalog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Client;
import com.algalog.domain.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRespository;
	
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
	public Client add(@RequestBody Client client) {
		return clientRespository.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client) {
		if (!clientRespository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = clientRespository.save(client);
		
		return ResponseEntity.ok(client);
	}
}
