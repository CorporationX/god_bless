package ru.kraiush.BJS2_18589;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppCollectingUsersByHobbies {

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
        System.out.println("\nMap with User as a key and common hobbies and activities of users");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();
        res.forEach((K,V) -> System.out.println("user: "+ K + "\nfound common activity: " + V ));
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
