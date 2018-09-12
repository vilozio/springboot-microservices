package org.webapp.service;

import org.webapp.entity.User;

public interface UserService {
    User registerUser(User input);
    Iterable<User> findAll();
}
