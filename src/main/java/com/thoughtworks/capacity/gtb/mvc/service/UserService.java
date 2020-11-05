package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.NameAlreadyExitException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void registerUser(User user) throws NameAlreadyExitException {
        if (UserRepository.ListUsersName().contains(user.getUsername())) {
            throw new NameAlreadyExitException();
        }
        UserRepository.saveUser(user);
    }

    public User loginUser(String username, String password) throws LoginErrorException {
        if (!UserRepository.findUserByNameAndPassword(username, password).isEmpty()) {
            return UserRepository.findUserByNameAndPassword(username, password).get(0);

        }
        throw new LoginErrorException();
    }
}
