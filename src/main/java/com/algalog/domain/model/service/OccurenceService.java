package com.algalog.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.exception.BusinessException;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.Occurrence;
import com.algalog.domain.repository.DeliveryRepository;

@Service
public class OccurenceService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	private Occurrence register(Long deliveryId, String description) {
		Delivery delivery = deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new BusinessException("Delivery not found"));
		return delivery.addOccurence(description);
	}
}
