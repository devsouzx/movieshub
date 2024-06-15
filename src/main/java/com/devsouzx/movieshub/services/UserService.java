package com.devsouzx.movieshub.services;

import com.devsouzx.movieshub.domain.User;
import com.devsouzx.movieshub.dto.UserDTO;
import com.devsouzx.movieshub.repositories.UserRepository;
import com.devsouzx.movieshub.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.ObjenesisException;
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

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not Found"));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id) {
        userRepository.delete(findById(id));
    }
}
