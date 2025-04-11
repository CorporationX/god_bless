package userhobbies;

import lombok.Builder;
import lombok.Getter;

import java.util.*;

@Getter
@Builder
public class User {
    private final int id;
    private final String name;
    private final int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = (activities != null) ? new HashSet<>(activities) : new HashSet<>();
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {

            for (String hobby : user.getActivities()) {
                if (hobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}