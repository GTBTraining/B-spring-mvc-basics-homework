package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    private static List<User> userList=new ArrayList<>();
    private static Integer id = 1;
    public static void saveUser(User user){
        user.setId(id);
        userList.add(user);
        id++;
    }
    public static List<String> ListUsersName(){
        List<String> nameList= new ArrayList<>();
       userList.stream().forEach(user -> nameList.add(user.getUsername()));
        return nameList;
    }
    public static List<User> findUserByNameAndPassword(String name, String password){
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().equals(name)) {
                users.add(user);
            }
        }
        List<User> users1 = new ArrayList<>();
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                users1.add(user);
            }
        }
        return users1;

    }
}
