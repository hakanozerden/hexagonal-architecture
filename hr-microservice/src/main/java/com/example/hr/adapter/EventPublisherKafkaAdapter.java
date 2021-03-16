package com.example.hr.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.dto.EmployeeKafkaEvent;
import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hakan.ozerden
 */
@Service
@Slf4j
public class EventPublisherKafkaAdapter implements EventPublisher {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void publish(EmployeeEvent event) {
		var employeeKafkaEvent = modelMapper.map(event, EmployeeKafkaEvent.class);
		try {
			var jsonDocument = objectMapper.writeValueAsString(employeeKafkaEvent);
			kafkaTemplate.send("hr", jsonDocument);
		} catch (Exception e) {
			log.error("Error occurred while serialization event.", e);
		}
	}

}
