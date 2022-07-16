package com.gl.employeeapi.service;
import com.gl.employeeapi.model.User;
import com.gl.employeeapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("No user found."));
    }

    @Transactional
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public User updateUser(User user, long userName) {
        return userRepository.save(user);
    }
}
