package UserRegistration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> bobActivities = new HashSet<>();
        bobActivities.add("Sport");
        bobActivities.add("Programming");
        bobActivities.add("Education");
        User bob = new User(0, "Bob", 99, bobActivities);

        Set<String> robActivities = new HashSet<>();
        robActivities.add("Music");
        User rob = new User(1, "Rob", 99, robActivities);

        Set<String> findActivities = new HashSet<>();
        findActivities.add("Programming");

        List<User> users = new ArrayList<>();
        users.add(bob);
        users.add(rob);

        System.out.println(User.findHobbyLovers(users, findActivities));
    }
}

