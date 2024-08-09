package faang.school.godbless.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        checkFindHobbyLovers();
        checkGroupUsers();
    }

    public static void checkFindHobbyLovers() {
        Set<String> aliceActivities = new HashSet<>(Arrays.asList("Football", "Reading", "Coding"));
        Set<String> bobActivities = new HashSet<>(Arrays.asList("Basketball", "Cooking", "Coding"));
        Set<String> charlieActivities = new HashSet<>(Arrays.asList("Swimming", "Reading", "Gaming"));

        try {
            User alice = new User("Alice", 25, aliceActivities, "Google", "London");
            User bob = new User("Bob", 30, bobActivities, "Uber ", "London");
            User charlie = new User("Charlie", 22, charlieActivities, "Google", "London");

            List<User> users = Arrays.asList(alice, bob, charlie);

            Set<String> targetActivities = new HashSet<>(Arrays.asList("Coding", "Gaming", "Reading"));

            Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetActivities);

            for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
                System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void checkGroupUsers() {
        try {
            Set<String> activities = new HashSet<>(Arrays.asList("Football", "Reading", "Coding"));
            User alice = new User("Alice", 25, activities, "Google", "London");
            User bob = new User("Bob", 25, activities, "Uber", "London");
            User charlie = new User("Charlie", 22, activities, "Google", "London");
            User max = new User("Max", 22, activities, "Amazon", "London");

            Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(Arrays.asList(alice, bob, charlie, max));
            for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}