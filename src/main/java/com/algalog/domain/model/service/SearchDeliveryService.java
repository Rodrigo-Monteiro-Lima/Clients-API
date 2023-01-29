package com.algalog.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algalog.domain.exception.BusinessException;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.Occurrence;
import com.algalog.domain.repository.DeliveryRepository;

@Service
public class SearchDeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public Delivery search(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new BusinessException("Delivery not found"));
	}
	
}
