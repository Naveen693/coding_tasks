package com.coding.tasks.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coding.tasks.pojos.Employee;

@Component
public class StreamsService {

	public List<Employee> sortEmployees(List<Employee> employees) {
		employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getLastName))
				.thenComparing(Comparator.comparing(Employee::getFirstName)));
		return employees;
	}
}
