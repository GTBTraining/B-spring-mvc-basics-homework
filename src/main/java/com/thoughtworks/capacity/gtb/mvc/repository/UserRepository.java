package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> userList=new ArrayList<>();
    public static void saveUser(User user){
        userList.add(user);
    }
}
