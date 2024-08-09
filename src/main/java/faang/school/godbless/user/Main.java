package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        checkFindHobbyLovers();
        checkGroupUsers();
    }

    public static void checkFindHobbyLovers() {
        Set<String> aliceActivities = new HashSet<>(Arrays.asList("Football", "Reading", "Coding"));
        Set<String> bobActivities = new HashSet<>(Arrays.asList("Basketball", "Cooking", "Coding"));
        Set<String> charlieActivities = new HashSet<>(Arrays.asList("Swimming", "Reading", "Gaming"));

        User alice = new User("Alice", 25, aliceActivities);
        User bob = new User("Bob", 30, bobActivities);
        User charlie = new User("Charlie", 22, charlieActivities);

        List<User> users = Arrays.asList(alice, bob, charlie);

        Set<String> targetActivities = new HashSet<>(Arrays.asList("Coding", "Gaming", "Reading"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetActivities);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }

    public static void checkGroupUsers() {
        Set<String> activities = new HashSet<>(Arrays.asList("Football", "Reading", "Coding"));
        User alice = new User("Alice", 25, activities);
        User bob = new User("Bob", 25, activities);
        User charlie = new User("Charlie", 22, activities);
        User max = new User("Max", 22, activities);

        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(Arrays.asList(alice, bob, charlie, max));
        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static class User {
        private final String name;
        private final int age;
        private final UUID id;
        private final Set<String> activities;

        public User(String name, int age, Set<String> activities) {
            this.name = name;
            this.age = age;
            this.id = UUID.randomUUID();
            this.activities = activities;
        }

        public String getName() {
            return name;
        }


        public Set<String> getActivities() {
            return activities;
        }

        public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
            Map<User, String> map = new HashMap<>();
            for (User user : users) {
                for (String activity : user.getActivities()) {
                    if (targetActivities.contains(activity)) {
                        map.put(user, activity);
                        break;
                    }
                }
            }
            return map;
        }

        public static Map<Integer, List<User>> groupUsers(List<User> users) {
            Map<Integer, List<User>> map = new HashMap<>();
            for (User user : users) {
                map.computeIfAbsent(user.age, (k) -> new ArrayList<>()).add(user);
            }
            return map;
        }

        @Override
        public String toString() {
            return this.name + "(" + this.age + ")";
        }
    }
}
