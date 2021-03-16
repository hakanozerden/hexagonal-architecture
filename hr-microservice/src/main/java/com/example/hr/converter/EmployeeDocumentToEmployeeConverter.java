package com.example.hr.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Currency;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Identity;

/**
 * @author hakan.ozerden
 */
@Component
public class EmployeeDocumentToEmployeeConverter extends AbstractConverter<EmployeeDocument, Employee> {

	private final ModelMapper mapper;

	@Autowired
	public EmployeeDocumentToEmployeeConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@PostConstruct
	public void register() {
		this.mapper.addConverter(this);
	}

	@Override
	protected Employee convert(EmployeeDocument source) {
		return new Employee.Builder(Identity.valueOf(source.getIdentity())).fullname(source.getFullname())
				.birthYear(source.getBirthYear()).iban(source.getIban()).salary(source.getSalary(), Currency.TRY)
				.jobType(source.getJobType().name()).department(source.getDepartment().name())
				.photo(source.getPhoto().getBytes()).build();
	}

}
