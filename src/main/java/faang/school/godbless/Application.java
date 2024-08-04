package faang.school.godbless;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        User user1 = new User(1, "Jake", 18);
        User user2 = new User(2, "Stacy", 21);
        User user3 = new User(3, "Larry", 30);
        User user4 = new User(4, "Ann", 19);

        HashSet<User> usersList = new HashSet<User>();
        Collections.addAll(usersList, user1, user2, user3, user4);

        user1.setActivities(new String[]{"Photography", "DIY", "Games", "Picnic"});
        user2.setActivities(new String[]{"Hiking", "Picnic", "Yoga", "Photography"});
        user3.setActivities(new String[]{"Coding", "Reading", "Games", "Music"});
        user4.setActivities(new String[]{"Meditation", "Music", "Reading", "Yoga"});

        HashSet<String> targetActivities = new HashSet<>();
        Collections.addAll(targetActivities, "Games", "Reading");

        System.out.println(User.findHobbyLovers(usersList, targetActivities));
        System.out.println(User.findHobbyLovers(usersList, user1.getActivities()));

    }
}