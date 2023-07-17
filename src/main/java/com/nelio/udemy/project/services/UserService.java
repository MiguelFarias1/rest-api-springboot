package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.User;
import com.nelio.udemy.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {return userRepository.findAll();}

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) return user.get();

        else
            throw new IllegalArgumentException("User not found !");
    }
}
