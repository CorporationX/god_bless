package com.basic;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> allActivities = List.of("football", "tennis", "basketball", "hockey");

        User user = new User();

        User david = new User(1, "David", 28, List.of("tennis", "box", "hockey"));
        User vlad= new User(2, "Vlad", 22, List.of("football", "running"));
        User denis = new User(3, "Denis", 31, List.of("snowboarding"));

        List<User> userList = List.of(david, vlad, denis);

        if(user.findHobbyLovers(userList, allActivities).isEmpty()){
            System.out.println("Map is Empty");
        } else System.out.println(user.findHobbyLovers(userList, allActivities));

    }
}
