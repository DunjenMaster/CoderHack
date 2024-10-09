package com.crio.coderhack.service;

import com.crio.coderhack.entities.User;
import com.crio.coderhack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User registerUser(User user) {
        user.setScore(0);
        user.setBadges(List.of());  // Initialize badges as an empty list
        return userRepository.save(user);
    }

    public User updateScore(String userId, int score) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setScore(score);
            
            // Logic to award badges
            if (score >= 1 && score < 30) {
                user.setBadges(List.of("Code Ninja"));
            } else if (score >= 30 && score < 60) {
                user.setBadges(List.of("Code Ninja", "Code Champ"));
            } else if (score >= 60 && score <= 100) {
                user.setBadges(List.of("Code Ninja", "Code Champ", "Code Master"));
            }

            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
