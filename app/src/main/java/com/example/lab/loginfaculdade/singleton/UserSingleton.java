package com.example.lab.loginfaculdade.singleton;

import com.example.lab.loginfaculdade.model.User;

import java.util.HashMap;

/**
 * Created by leandrocazarini on 22/03/17.
 */

public class UserSingleton {

    public static UserSingleton userSingleton;

    public HashMap<String,User> hashMapUser = new HashMap<>();

    public User sessionUser;

    public static UserSingleton getInstance(){
        if(userSingleton == null)
            userSingleton = new UserSingleton();

        return userSingleton;
    }





}
