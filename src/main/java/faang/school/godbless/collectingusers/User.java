package faang.school.godbless.collectingusers;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class User {

    private String id;
    private String name;
    private int age;
    private Set<String> activities = new HashSet<>();

    public User(String id, String name, int age, Set<String> activities) {
        validateInputs(id, name, age);

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();

            for (String activity : userActivities) {
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }

        return hobbyLovers;
    }

    private void validateInputs(String id, String name, int age) {
        if (id.isBlank()) {
            throw new IllegalArgumentException("Id can't be empty");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Age can't be less than 0");
        }
    }
}
