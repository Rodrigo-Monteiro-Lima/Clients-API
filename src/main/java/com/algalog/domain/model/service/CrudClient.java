package com.algalog.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.exception.BusinessException;
import com.algalog.domain.model.Client;
import com.algalog.domain.repository.ClientRepository;

@Service
public class CrudClient {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client find(Long clientId) {
		return clientRepository.findById(clientId)
				.orElseThrow(() -> new BusinessException("Client not found"));
	}
	
	@Transactional
	public Client save(Client client) {
		boolean isSaved = clientRepository.findByEmail(client.getEmail())
				.stream().anyMatch(clientExist -> !clientExist.equals(client));
		if(isSaved) {
			throw new BusinessException("There's already a customer registered with this email");
		}
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
