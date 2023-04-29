package com.geekster.UserManagement.repository;

import com.geekster.UserManagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    List<User> userList = new ArrayList<>();
    public String save(User user) {
        userList.add(user);
        return "user added successfully!!";
    }

    public List<User> getUsers() {
        return userList;
    }


    public boolean updateUserBYId(String userId,User user) {
        for(User obj:userList){
            if(obj.getUserId().equals(userId)){
                obj.setUserName(user.getUserName());
                obj.setDateOFBirth(user.getDateOFBirth());
                obj.setEmail(user.getEmail());
                obj.setPhoneNumber(user.getPhoneNumber());
                obj.setDate(user.getDate());
                obj.setTime(user.getTime());

                return true;
            }
        }
        return false;
    }

    public boolean removeUserById(User user) {
        userList.remove(user);
        return true;
    }
}
