package faang.school.godbless.sprint_2.task_4;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> findHobbyLovers = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            Set<String> intersection = new HashSet<>(activities);
            intersection.retainAll(userActivities);
            if (!intersection.isEmpty()) {
                findHobbyLovers.put(user, intersection.iterator().next());
            }
        }
        return findHobbyLovers;
    }
}