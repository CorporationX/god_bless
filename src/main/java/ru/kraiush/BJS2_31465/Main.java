package ru.kraiush.BJS2_31465;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

    enum Activities {
        RUNNING,
        SWIMMING,
        HIKING,
        FOOTBALL,
        READING,
        TRAVELING,
        FISHING,
        ART
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            users.add(new User(i, "User_" + i, new Random().nextInt(10, 70), getRandomSetOfActivities()));
        }

        for (Map.Entry<User, String> entry : User.findHobbyLovers(users, Set.of("TRAVELING", "ART", "HIKING")).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("___________________");

        for (Map.Entry<User, String> entry : User.findHobbyLovers(users, Set.of("SWIMMING", "READING")).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Set<String> getRandomSetOfActivities() {
        Set<String> randomActivities = new HashSet<>();
        Activities[] allActivities = Activities.values();
        int lengthOfActivitiesArray = allActivities.length;
        Random random = new Random();
        int numberOfActivitiesInSet = 1 + random.nextInt(lengthOfActivitiesArray);
        while (randomActivities.size() < numberOfActivitiesInSet) {
            Activities activity = allActivities[random.nextInt(lengthOfActivitiesArray)];
            randomActivities.add(activity.name());
        }
        return randomActivities;
    }
}
