package ru.kraiush.model.BJS218540;

import ru.kraiush.model.model.User;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Set<String> checkSet = new HashSet();
        checkSet.add("sailing");
        checkSet.add("music");
        checkSet.add("drinking");

        Map<User, String> res= User.findHobbyLovers(checkSet);

        res.forEach((K,V) -> System.out.println("user: "+ K + " activity: " + V));
    }
}