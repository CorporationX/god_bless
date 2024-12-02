package school.faang.task_43949.model;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class User {
    private long id;
    private String name;
    private int age;
    private final Set<String> activities = new HashSet<>();

    public User(long l, String alice, int i, HashSet<String> activities) {
        this.id = l;
        this.name = alice;
        this.age = i;
        this.activities.addAll(activities);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        return users.stream()
                .flatMap(user -> user.activities.stream()
                        .filter(activities::contains)
                        .limit(1)
                        .map(activity -> Map.entry(user, activity)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
