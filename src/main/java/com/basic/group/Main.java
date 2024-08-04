package com.basic.group;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        User user1 = new User("Ivan", 23, "factory", "street A1");
        User user2 = new User("Mary", 26, "shop", "street A2");
        User user3 = new User("Nikola", 23, "shipyard", "street A3");
        User user4 = new User("Bred", 26, "railway", "street A4");

        List<User> users = List.of(user1, user2, user3, user4);

        System.out.println(   User.groupUser(users));

        System.out.println(users.contains(user1));
    }


}
