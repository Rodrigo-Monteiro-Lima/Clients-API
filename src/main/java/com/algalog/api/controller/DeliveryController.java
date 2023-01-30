package com.algalog.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.algalog.api.assembler.DeliveryAssembler;
import com.algalog.api.model.DeliveryModel;
import com.algalog.api.model.RecipientModel;
import com.algalog.api.model.input.DeliveryInput;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.service.DeliveryService;
import com.algalog.domain.model.service.FinalizationDeliveryService;
import com.algalog.domain.repository.DeliveryRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private DeliveryAssembler deliveryAssembler;
	@Autowired
	private FinalizationDeliveryService finalizationDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModel request(@Valid @RequestBody DeliveryInput deliveryInput) {
		Delivery newDelivery = deliveryAssembler.toEntity(deliveryInput);
		Delivery addDelivery =  deliveryService.add(newDelivery);
		return deliveryAssembler.toModel(addDelivery);
	}
	
	@GetMapping
	public List<DeliveryModel> list() {
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryModel> search(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/finalization")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void end(@PathVariable Long deliveryId) {
		finalizationDeliveryService.conclude(deliveryId);
	}
}
