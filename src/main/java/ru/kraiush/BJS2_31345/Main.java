package ru.kraiush.BJS2_31345;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User("Username" + i,
                    new Random().nextInt(18, 66),
                    "Company " + i,
                    "Address " + i);
            users.add(user);
        }

        Map<Integer, List<User>> groupedUsersByAgeV1 = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry: groupedUsersByAgeV1.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(" - " + user);
            }
        }
    }
}
