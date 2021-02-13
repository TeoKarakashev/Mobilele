package com.example.mobilele.Service;

public interface UserService {

    boolean authenticate (String username, String password);

    void loginUser(String username);

    void logoutCurrentUser();
}
