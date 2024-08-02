package faang.school.godbless.collectingUsers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String... args) {
        Set<String> activitiesForMethod = new HashSet<>(Set.of("Gym", "Cooking", "Playing", "Sleeping"));
        User user = new User(0, "Name", 0, activitiesForMethod);

        List<User> users = List.of(
                new User(1, "Mike", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2"))),
                new User(2, "Bob", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))),
                new User(3, "Jack", 41, new HashSet<>(Set.of("Some activities", "Some activities1"))),
                new User(4, "Sam", 18, new HashSet<>(Set.of("Some activities", "Playing", "Some activities1"))),
                new User(5, "Amanda", 24, new HashSet<>(Set.of("Cooking", "Some activities", "Some activities1"))),
                new User(6, "Mary", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Sleeping"))),
                new User(7, "Abby", 34, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities3", "Some activities2"))),
                new User(8, "Tom", 23, new HashSet<>(Set.of("Some activities", "Some activities1", "Gym"))),
                new User(9, "Petter", 41, new HashSet<>(Set.of("Some activities", "Some activities1"))),
                new User(10, "Sam", 18, new HashSet<>(Set.of("Some activities", "Playing", "Some activities1"))),
                new User(11, "Lucy", 24, new HashSet<>(Set.of("Cooking", "Some activities", "Some activities1"))),
                new User(12, "Katy", 19, new HashSet<>(Set.of("Some activities", "Some activities1", "Some activities2", "Sleeping")))
        );

        Map<User, String> userActivitiesMap = user.findHobbyLovers(users, activitiesForMethod);

        System.out.println("Activities: " + activitiesForMethod);

        for (Map.Entry<User, String> entry : userActivitiesMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }

    }
}
