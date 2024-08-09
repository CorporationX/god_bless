package faang.school.godbless.collerctions_user;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(UUID id, String name, int age, Set<String> activities) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("User age cannot be negative");
        }
        if (activities == null || activities.isEmpty()) {
            throw new IllegalArgumentException("User activities cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    hobbyLovers.put(user, activity);
                }
            }
        }
        return hobbyLovers;
    }
}
