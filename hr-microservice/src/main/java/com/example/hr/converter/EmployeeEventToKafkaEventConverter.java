package com.example.hr.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hr.dto.EmployeeKafkaEvent;
import com.example.hr.events.EmployeeEvent;

/**
 * @author hakan.ozerden
 */
@Component
public class EmployeeEventToKafkaEventConverter extends AbstractConverter<EmployeeEvent, EmployeeKafkaEvent> {

	private final ModelMapper mapper;

	@Autowired
	public EmployeeEventToKafkaEventConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@PostConstruct
	public void register() {
		this.mapper.addConverter(this);
	}

	@Override
	protected EmployeeKafkaEvent convert(EmployeeEvent source) {
		return new EmployeeKafkaEvent(source.getIdentity().getValue());
	}

}
