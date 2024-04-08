package faang.school.godbless.collecting_users;


import lombok.Data;

import java.util.*;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
