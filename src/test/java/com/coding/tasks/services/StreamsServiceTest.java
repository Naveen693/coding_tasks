package com.coding.tasks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.coding.tasks.pojos.Employee;

public class StreamsServiceTest {

	@Test
	public void testEmployeesSort() {
		StreamsService service = new StreamsService();
		List<Employee> sortedEmployees = service.sortEmployees(Arrays.asList(createEmployee("Peter", "Carpenter", 50),
				createEmployee("Bob", "Marly", 35), createEmployee("John", "Carpenter", 45)));
		assertNotNull(sortedEmployees);
		assertEquals(sortedEmployees.get(0).getAge(), 35);
		assertEquals(sortedEmployees.get(1).getLastName(), "John");
		assertEquals(sortedEmployees.get(2).getLastName(), "Peter");
	}

	private Employee createEmployee(String lastName, String firstName, int age) {
		return new Employee(lastName, firstName, age);
	}
}
