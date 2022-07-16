package com.gl.employeeapi.util;

import com.gl.employeeapi.model.Employee;
import com.gl.employeeapi.model.Role;
import com.gl.employeeapi.model.User;
import com.gl.employeeapi.repository.EmployeeRepository;
import com.gl.employeeapi.repository.RoleRepository;
import com.gl.employeeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BootStrapAppData implements ApplicationListener<ApplicationReadyEvent> {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // implement faker here
        for(int i=0; i<3; i++) {
            Employee emp = new Employee();
            emp.setFirstName("Maddy" + i);
            emp.setLastName("R" + i);
            emp.setCountry("India" + i);
            emp.setEmail("maddy@test" + i + ".com");
            employeeRepository.save(emp);
        }


        Role userRole=new Role();
        userRole.setRoleName("ROLE_USER");

        Role adminRole=new Role();
        adminRole.setRoleName("ROLE_ADMIN");



        User user=new User();
        user.setUserName("user");
        user.setPassword(this.passwordEncoder.encode("user"));

        User admin=new User();
        admin.setUserName("admin");
        admin.setPassword(this.passwordEncoder.encode("admin"));

        admin.addRole(adminRole);
        admin.addRole(userRole);

        user.addRole(userRole);

        userRepository.save(user);
        userRepository.save(admin);
        roleRepository.save(userRole);
        roleRepository.save(adminRole);
    }

}
