package com.algalog.domain.model.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.exception.BusinessException;
import com.algalog.domain.model.Client;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.DeliveryStatus;
import com.algalog.domain.repository.ClientRepository;
import com.algalog.domain.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private CrudClient crudClient;
	
	@Transactional
	public Delivery add(Delivery delivery) {
		Client client = crudClient.find(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrdererDate(OffsetDateTime.now());		
		
		return deliveryRepository.save(delivery);
	}
}
