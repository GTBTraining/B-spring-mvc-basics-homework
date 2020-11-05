package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static List<User> userList=new ArrayList<>();
    public static void saveUser(User user){
        userList.add(user);
    }
    public static List<String> ListUsersName(){
        List<String> nameList= new ArrayList<>();
       userList.stream().forEach(user -> nameList.add(user.getUsername()));
        return nameList;
    }
}
