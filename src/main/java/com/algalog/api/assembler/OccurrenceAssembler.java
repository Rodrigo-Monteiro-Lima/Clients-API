package com.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algalog.api.model.OccurrenceModel;
import com.algalog.domain.model.Delivery;
import com.algalog.domain.model.Occurrence;

@Component
public class OccurrenceAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OccurrenceModel toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceModel.class);
	}
	
	public List<OccurrenceModel> toCollectionModel (List<Occurrence> occurrences) {
		return occurrences.stream()
				.map(this::toModel)
				.collect(Collectors.toList());				
	}

}
