package khuedev_portfolio.portfolio.service;

import java.util.List;

import khuedev_portfolio.portfolio.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
