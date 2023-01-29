package com.algalog.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algalog.api.model.DeliveryModel;
import com.algalog.domain.model.Delivery;

@Component
public class DeliveryAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public DeliveryModel toModel (Delivery delivery) {
		return modelMapper.map(delivery, DeliveryModel.class);
	}
}
