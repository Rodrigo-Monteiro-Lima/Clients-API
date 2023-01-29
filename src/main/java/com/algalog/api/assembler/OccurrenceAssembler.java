package com.algalog.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algalog.api.model.OccurrenceModel;
import com.algalog.domain.model.Occurrence;

@Component
public class OccurrenceAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OccurrenceModel toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceModel.class);
	}

}
