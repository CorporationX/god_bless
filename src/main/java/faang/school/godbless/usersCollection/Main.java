package faang.school.godbless.usersCollection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vadim", 21, Set.of("Reading", "Drawing", "Travel")));
        users.add(new User(2, "Oleg", 22, Set.of("Cooking", "Football", "Photography")));
        users.add(new User(3, "Petr", 21, Set.of("Gaming", "Tennis", "Reading")));

        Set<String> activities = Set.of("Football", "Tennis", "Gaming");

        Map<User, String> hobbyLovers = findHobbyLovers(users, activities);

        hobbyLovers.forEach((key, value) -> System.out.println(key.getName() + ": " + value));
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userActivities = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    userActivities.put(user, activity);
                    break;
                }
            }
        }
        return userActivities;
    }
}
