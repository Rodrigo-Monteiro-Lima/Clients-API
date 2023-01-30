package com.algalog.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.exception.BusinessException;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.DeliveryStatus;
import com.algalog.domain.repository.DeliveryRepository;

@Service
public class FinalizationDeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private SearchDeliveryService searchDeliveryService;
	
	@Transactional
	public void conclude(Long deliveryId) {
		Delivery delivery = searchDeliveryService.search(deliveryId);
		
		delivery.conclude();
		
		deliveryRepository.save(delivery);
	}
}
