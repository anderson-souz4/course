package com.github.course.services;


import com.github.course.entities.User;
import com.github.course.repositories.UserRepository;
import com.github.course.services.exceptions.DataBaseException;
import com.github.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }


    /**
     * @param id
     * @param user
     * @return
     */
    public User update(Long id, User user) {
        User entity = userRepository.getReferenceById(id); // Ele prepara o objeto para ser alterado, o findById já traz o objeto pelo id
        updateData(entity, user); // método para atualizar o usuario, como usuario vindo por parametro
        return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
