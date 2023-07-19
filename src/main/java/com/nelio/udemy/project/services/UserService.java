package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.User;
import com.nelio.udemy.project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {return userRepository.findAll();}

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) return user.get();

        else
            throw new IllegalArgumentException("User not found !");
    }

    public User insert(User user) {
        return userRepository.save(user);
    }
}
