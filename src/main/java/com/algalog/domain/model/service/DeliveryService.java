package com.algalog.domain.model.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.DeliveryStatus;
import com.algalog.domain.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery add(Delivery delivery) {
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrdererDate(LocalDateTime.now());		
		
		return deliveryRepository.save(delivery);
	}
}
