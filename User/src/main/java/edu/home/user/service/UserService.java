package edu.home.user.service;

import edu.home.user.dto.UserDTO;
import edu.home.user.model.User;
import edu.home.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserDTO save(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty() &&
            userRepository.findByEmail(user.getEmail()).isEmpty()) {
            User saved_user = userRepository.save(user);
            return new UserDTO(saved_user.getUsername(), saved_user.getEmail(), saved_user.getPassword());
        }
        return null;
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }
}
