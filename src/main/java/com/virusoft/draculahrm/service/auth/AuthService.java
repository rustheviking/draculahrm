package com.virusoft.draculahrm.service.auth;

import com.virusoft.draculahrm.dao.auth.UserDAO;
import com.virusoft.draculahrm.model.auth.User;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public boolean registerUser(String username, String password, String role) {
        if (userDAO.findByUsername(username) != null) return false;
        userDAO.saveUser(new User(username, password, role));
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

