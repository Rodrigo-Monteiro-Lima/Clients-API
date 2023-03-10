package com.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.api.assembler.OccurrenceAssembler;
import com.algalog.api.model.OccurrenceModel;
import com.algalog.api.model.input.OccurrenceInput;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.Occurrence;
import com.algalog.domain.model.service.RegistrateOccurenceService;
import com.algalog.domain.model.service.SearchDeliveryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {
	
	@Autowired
	private RegistrateOccurenceService registrateOccurenceService;
	@Autowired
	private OccurrenceAssembler occurrenceAssembler;
	@Autowired
	private SearchDeliveryService searchDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceModel register(@PathVariable Long deliveryId,
			@Valid @RequestBody OccurrenceInput occurrenceInput) {
		
		Occurrence registeredOccurrence = registrateOccurenceService
				.register(deliveryId, occurrenceInput.getDescription());
		
		return occurrenceAssembler.toModel(registeredOccurrence);
	}
	
	@GetMapping
	public List<OccurrenceModel> list(@PathVariable Long deliveryId) {
		Delivery delivery = searchDeliveryService.search(deliveryId);
		
		return occurrenceAssembler.toCollectionModel(delivery.getOccurrences());
	}

}
