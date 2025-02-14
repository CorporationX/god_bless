package school.faang.collectingUsers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = (activities != null) ? activities : new HashSet<>();
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    public void removeActivity(String activity) {
        activities.remove(activity);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        if (users == null || users.isEmpty() || hobbies == null || hobbies.isEmpty()) {
            return new HashMap<>();
        }

        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}
