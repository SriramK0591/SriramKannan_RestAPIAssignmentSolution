package com.gl.employeeapi.controller;
import com.gl.employeeapi.model.Role;
import com.gl.employeeapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<Role> fetchRoles() {
        return roleService.findAllRoles();
    }

    @GetMapping("/{id}")
    public Role fetchRole(@PathVariable("id") int roleId) {
        return roleService.findById(roleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role saveRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@RequestBody Role role, @PathVariable("id") int roleId) {
        return roleService.updateRole(role, roleId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable("id") int roleId) {
        roleService.deleteRole(roleId);
    }

}
