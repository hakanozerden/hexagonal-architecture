package com.example.hr.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;

/**
 * @author hakan.ozerden
 */
@Component
public class EmployeeToEmployeeDocumentConverter extends AbstractConverter<Employee, EmployeeDocument> {

	private final ModelMapper mapper;

	@Autowired
	public EmployeeToEmployeeDocumentConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@PostConstruct
	public void register() {
		this.mapper.addConverter(this);
	}

	@Override
	protected EmployeeDocument convert(Employee source) {
		return EmployeeDocument.builder().identity(source.getidentity().getValue())
				.fullname(source.getFullname().getValue()).salary(source.getSalary().getValue())
				.birthYear(source.getBirthYear().getValue()).iban(source.getIban().getValue())
				.department(source.getDepartment()).jobType(source.getJobType())
				.photo(new String(source.getPhoto().getData())).build();
	}

}
