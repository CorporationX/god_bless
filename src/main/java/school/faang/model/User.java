package school.faang.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private final Set<String> activities = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        return users.stream()
                .flatMap(user -> user.activities.stream()
                        .filter(activities::contains)
                        .limit(1)
                        .map(activity -> Map.entry(user, activity)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
