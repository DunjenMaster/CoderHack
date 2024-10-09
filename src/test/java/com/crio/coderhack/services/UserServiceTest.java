package com.crio.coderhack.services;

import com.crio.coderhack.entities.User;
import com.crio.coderhack.repositories.UserRepository;
import com.crio.coderhack.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for registering a new user
    @Test
    public void testRegisterUser() {
        User user = new User("12345", "john_doe", 0, List.of());
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.registerUser(user);

        assertEquals("12345", createdUser.getUserId());
        assertEquals(0, createdUser.getScore());
        assertEquals(List.of(), createdUser.getBadges());
        verify(userRepository, times(1)).save(user);
    }

    // Test for retrieving user details
    @Test
    public void testGetUserById() {
        User user = new User("12345", "john_doe", 0, List.of());
        when(userRepository.findById("12345")).thenReturn(Optional.of(user));

        Optional<User> retrievedUser = userService.getUserById("12345");

        assertTrue(retrievedUser.isPresent());
        assertEquals("12345", retrievedUser.get().getUserId());
        assertEquals("john_doe", retrievedUser.get().getUsername());
        verify(userRepository, times(1)).findById("12345");
    }

    // Test for updating user score and awarding badges
    @Test
    public void testUpdateScore() {
        User user = new User("12345", "john_doe", 0, List.of());
        when(userRepository.findById("12345")).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.updateScore("12345", 35);

        assertEquals(35, updatedUser.getScore());
        assertEquals(List.of("Code Ninja", "Code Champ"), updatedUser.getBadges());
        verify(userRepository, times(1)).save(user);
    }

    // Test for deleting a user
    @Test
    public void testDeleteUser() {
        String userId = "12345";
        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    // Additional test to verify the behavior when trying to get a non-existent user
    @Test
    public void testGetNonExistentUser() {
        when(userRepository.findById("67890")).thenReturn(Optional.empty());

        Optional<User> user = userService.getUserById("67890");

        assertFalse(user.isPresent());
        verify(userRepository, times(1)).findById("67890");
    }

    // Test for registering a user that already exists (could be an optional test)
    @Test
    public void testRegisterExistingUser() {
        User user = new User("12345", "john_doe", 0, List.of());
        when(userRepository.findById("12345")).thenReturn(Optional.of(user));

        Optional<User> existingUser = userService.getUserById("12345");

        assertTrue(existingUser.isPresent());
        assertEquals("12345", existingUser.get().getUserId());
        verify(userRepository, times(1)).findById("12345");
    }
}
