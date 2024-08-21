package faang.school.godbless.Task;

import lombok.Data;

import java.util.*;

@Data
public class User {

    private static int id = 1;
    private int instanceId;
    private String name;
    private int age;
    private Set<String> activities;

    public User(String name, int age, Set<String> activities) {
        this.instanceId = id++;  // automatically generated id for users
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findUser(List<User> users, Set<String> hobbies) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("Users list is empty");
        }

        if(hobbies.isEmpty()) {
            throw new IllegalArgumentException("Hobbies list is empty");
        }

        Map<User, String> findUser = new LinkedHashMap<>();  // Preserve insertion order
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    findUser.put(user, hobby);
                    break;   // Stop searching once the first match is found
                }
            }
        }
        return findUser;
    }
}


