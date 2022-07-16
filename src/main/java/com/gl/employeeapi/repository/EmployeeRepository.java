package com.gl.employeeapi.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeeapi.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrderByFirstNameDesc();
    List<Employee> findAllByOrderByFirstNameAsc();
    List<Employee> findByFirstName(String firstName);
}
