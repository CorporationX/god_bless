package school.faang.sprint1.task_56311;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activites) {
        this.id = validateId(id);
        this.name = validateName(name);
        this.age = validateAge(age);
        this.activities = validateActivities(activites);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    result.put(user, activity);
                }
            }
        }
        return result;
    }

    private int validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cant be negative --> " + id);
        }
        return id;
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cant be empty or null ");
        }
        return name;
    }

    private int validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cant be negative --> " + age);
        }
        return age;
    }

    private Set<String> validateActivities(Set<String> activities) {
        if (activities == null) {
            throw new IllegalArgumentException("Activities cant be null");
        }
        if (activities.isEmpty()) {
            throw new IllegalArgumentException("Activities cant be empty");
        }
        for (String activity : activities) {
            if (activity == null || activity.isBlank()) {
                throw new IllegalArgumentException("Activity cant be empty or null");
            }
        }
        return activities;
    }
}
