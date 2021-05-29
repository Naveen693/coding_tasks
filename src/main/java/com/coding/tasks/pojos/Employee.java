package com.coding.tasks.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private String lastName;
	
	private String firstName;
	
	private int age;
}
