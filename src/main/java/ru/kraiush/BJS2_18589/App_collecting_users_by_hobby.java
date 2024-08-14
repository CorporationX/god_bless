package ru.kraiush.BJS2_18589;

import ru.kraiush.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class App_collecting_users_by_hobby {

    public static void main(String[] args) {

        Set<String> checkActivities = Set.of("sailing", "music", "drinking");

        List<User> users= User.getUsers();

        Map<User, String> res= User.findHobbyLovers(users, checkActivities);

        res.forEach((K,V) -> System.out.println("user: "+ K + " activity: " + V));
    }
}
