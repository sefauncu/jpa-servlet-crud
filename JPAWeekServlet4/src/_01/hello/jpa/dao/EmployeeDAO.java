package _01.hello.jpa.dao;

import java.util.List;

import _01.hello.jpa.model.Employee;



public interface EmployeeDAO {

	public void insertEmployee(Employee employee);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);

}
