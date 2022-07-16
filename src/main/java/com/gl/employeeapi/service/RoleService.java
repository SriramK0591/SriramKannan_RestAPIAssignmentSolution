package com.gl.employeeapi.service;

import com.gl.employeeapi.model.Role;
import com.gl.employeeapi.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    public Role findById(int roleId) {
        return roleRepository.findById(roleId).orElseThrow(()->new IllegalArgumentException("No role found."));
    }

    @Transactional
    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    @Transactional
    public Role updateRole(Role role, int roleId) {
        return roleRepository.save(role);
    }
}
