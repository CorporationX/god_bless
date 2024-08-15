package ru.kraiush.BJS2_18589;

import ru.kraiush.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App_collecting_users_by_hobby {

    public static void main(String[] args) {

        Set<String> checkActivities = Set.of("sailing", "music", "drinking");

        List<User> users= User.getUsers();

        System.out.println("\nList of Users with their hobbies");
        System.out.print(String.join("", Collections.nCopies(80, "-")));

        System.out.println();

        users.forEach(System.out::println);
        System.out.println("\nSet of activities to compare with users Set of hobbies");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\n" + checkActivities);


        Map<User, String> res= User.findHobbyLovers(users, checkActivities);
        System.out.println("\nMap with User as a key and common users hobbies and activities");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        res.forEach((K,V) -> System.out.println("user: "+ K + "\nfound common activity: " + V ));
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
