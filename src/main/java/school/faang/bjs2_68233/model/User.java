package school.faang.bjs2_68233.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (String activity : activities) {
            users.stream()
                    .filter(user -> user.activities.contains(activity))
                    .forEach(user -> hobbyLovers.computeIfAbsent(user, key -> activity));
        }
        return hobbyLovers;
    }
}
