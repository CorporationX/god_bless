package com.basic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> allActivities = List.of("football", "tennis", "basketball", "hockey");

        User user = new User();

        User userOne = new User(1, "David", 28, List.of("tennis", "box", "hockey"));
        User userTwo = new User(2, "Vlad", 22, List.of("football", "running"));
        User userTree = new User(3, "Denis", 31, List.of("snowboarding"));

        List<User> userList = List.of(userOne, userTwo, userTree);

        System.out.println(user.findHobbyLovers(userList, allActivities));

    }
}
