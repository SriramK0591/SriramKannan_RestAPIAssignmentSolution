package com.gl.employeeapi.service;

import java.util.List;

import javax.transaction.Transactional;

import com.gl.employeeapi.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.employeeapi.model.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Transactional
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public Employee findById(long id) {
		return employeeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No employee found."));
	}

	@Transactional
	public List<Employee> findByFirstName(String firstName) {
		List<Employee> response = (List<Employee>) employeeRepository.findByFirstName(firstName);
		return response;
	}

	@Transactional
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee, long employeeId) {
		return employeeRepository.save(employee);
	}

	@Transactional
	public List<Employee> findAllOrderByfirstNameDesc() {
		List<Employee> response = (List<Employee>) employeeRepository.findAllByOrderByFirstNameDesc();
		return response;
	}
	@Transactional
	public List<Employee> findAllOrderByfirstNameAsc() {
		List<Employee> response = (List<Employee>) employeeRepository.findAllByOrderByFirstNameAsc();
		return response;
	}
}
