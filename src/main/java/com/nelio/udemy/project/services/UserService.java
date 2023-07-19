package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.User;
import com.nelio.udemy.project.exceptions.ResourceNotFoundException;
import com.nelio.udemy.project.repositories.UserRepository;
import com.nelio.udemy.project.services.exceptions.DataBaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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

        return user.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado !"));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {

        try
        {
            userRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {

        try
        {
            var usuario = userRepository.getReferenceById(id);

            updateData(usuario, user);

            return userRepository.save(user);
        }

        catch (EntityNotFoundException e) {

            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    private void updateData(User dest, User src) {

        dest.setName(src.getName());
        dest.setEmail(src.getEmail());
        dest.setPhone(src.getPhone());
    }
}
