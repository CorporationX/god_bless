package faang.school.godbless;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Set<String> ivanActivities = new HashSet<>(Arrays.asList("reading", "swimming", "cycling"));
        Set<String> petrActivities = new HashSet<>(Arrays.asList("running", "swimming", "cooking"));
        Set<String> fedrActivities = new HashSet<>(Arrays.asList("gaming", "cycling", "hiking"));

        User ivan = new User(1, "Ivan", 36, ivanActivities);
        User petr = new User(2, "Petr", 25, petrActivities);
        User fedr = new User(3, "Fedr", 16, fedrActivities);

        List<User> users = new ArrayList<>(Arrays.asList(ivan, petr, fedr));
        Set<String> hobbyActivities = new HashSet<>(Arrays.asList("reading", "cycling"));
        Map<User, String> findResult = User.findHobbyLovers(users, hobbyActivities);

        for (Map.Entry<User, String> entry : findResult.entrySet()) {
            System.out.println(entry.getKey() + ", " + "his activities - " + entry.getValue());
        }
    }
}