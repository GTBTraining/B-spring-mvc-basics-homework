package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.exception.NameAlreadyExitException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void registerUser(User user) throws NameAlreadyExitException {
       if (UserRepository.ListUsersName().contains(user.getUsername())){
           throw new NameAlreadyExitException();
       }
    UserRepository.saveUser(user);
    }

}
