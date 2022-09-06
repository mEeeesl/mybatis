package ch06.presentation;

import ch06.service.EmployeeService;

public class EmployeeIo {
	private EmployeeService employeeService; //dependency를 멤버변수로 선언
	
	public EmployeeIo(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void play() {
		employeeService.getEmployees().forEach(System.out::println);
	}
}
