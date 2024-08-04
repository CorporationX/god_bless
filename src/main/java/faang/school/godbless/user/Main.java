package faang.school.godbless.user;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
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
    public static class User {
        private  String name;
        private int age;
        private UUID id;
        private Set<String> activities;

        public User(String name, int age, Set<String> activities) {
            this.name = name;
            this.age = age;
            this.id = UUID.randomUUID();
            this.activities = activities;
        }
        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
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
    }
}
