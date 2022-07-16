package com.gl.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeeapi.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
