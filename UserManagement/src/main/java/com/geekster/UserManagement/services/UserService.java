package com.geekster.UserManagement.services;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String addNewUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    public User getUserById(String userId){
        List<User> tempList = getAllUsers();
        for(User user:tempList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public String updateUser(String userId, User user) {
        boolean updateStatus = userDao.updateUserBYId(userId,user);

        if(updateStatus){
            return "User information updated!!!";
        }else{
            return "User is not available";
        }
    }

    public String deleteUserById(String userId) {
        List<User> tempList = getAllUsers();
        boolean deleteStatus = false;

        for(User user:tempList){
            if(user.getUserId().equals(userId)){
                deleteStatus = userDao.removeUserById(user);

                if(deleteStatus){
                    return "user of id " + userId + " deleted!!";
                }else{
                    return "user of id " + userId + " can't be deleted some error occurs in DataBase!!!";
                }
            }
        }

        return "user does not exists!!!";
    }
}
