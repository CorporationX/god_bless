package school.faang.bjs2_68069;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        users.forEach(user -> activities.stream()
                .filter(activity -> user.activities.contains(activity))
                .findFirst()
                .ifPresent(activity -> hobbyLovers.put(user, activity)));
        return hobbyLovers;
    }
}
