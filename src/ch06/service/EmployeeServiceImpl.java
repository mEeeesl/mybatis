package ch06.service;

import java.util.List;

import ch06.dao.EmployeeDao;
import ch06.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao; // dependency
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) { // DI - »ý¼ºÀÚ
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.selectEmployees();
	}
}
