package com.algalog.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.model.Client;
import com.algalog.domain.repository.ClientRepository;

@Service
public class CrudClient {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
