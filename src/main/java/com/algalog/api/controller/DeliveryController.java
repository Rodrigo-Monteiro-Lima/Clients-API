package com.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.api.model.DeliveryModel;
import com.algalog.api.model.RecipientModel;
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
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryModel> search(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> {
					DeliveryModel deliveryModel = new DeliveryModel();
					deliveryModel.setId(delivery.getId());
					deliveryModel.setClientName(delivery.getClient().getName());
					deliveryModel.setRecipient(new RecipientModel());
					deliveryModel.getRecipient().setName(delivery.getRecipient().getName());
					deliveryModel.getRecipient().setAdress(delivery.getRecipient().getAdress());
					deliveryModel.getRecipient().setNumber(delivery.getRecipient().getNumber());
					deliveryModel.getRecipient().setComplement(delivery.getRecipient().getComplement());
					deliveryModel.getRecipient().setNeighborhood(delivery.getRecipient().getNeighborhood());
					deliveryModel.setFee(delivery.getFee());
					deliveryModel.setStatus(delivery.getStatus());
					deliveryModel.setOrdererDate(delivery.getOrdererDate());
					deliveryModel.setFinishDate(delivery.getFinishDate());
					
					return ResponseEntity.ok(deliveryModel);					
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
