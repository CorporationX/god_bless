package faang.school.godbless.Task4;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(long id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.activities) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
