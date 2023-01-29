package com.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.service.DeliveryService;
import com.algalog.domain.repository.DeliveryRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@Valid @RequestBody Delivery delivery) {
		return deliveryService.add(delivery);
	}
	
	@GetMapping
	public List<Delivery> list() {
		return deliveryRepository.findAll();
	}
}
