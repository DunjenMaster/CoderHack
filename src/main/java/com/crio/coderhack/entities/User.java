package com.crio.coderhack.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private int score;
    private List<String> badges;

    // No-argument constructor
    public User() {
        this.badges = new ArrayList<>(); // Initialize badges with an empty list
    }

    // Parameterized constructor
    public User(String userId, String username, int score, List<String> badges) {
        this.userId = userId;
        this.username = username;
        this.score = score;
        this.badges = badges;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }

    public void updateScore(int score2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }
}
