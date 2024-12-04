package school.faang.sprint1.task_43993;

import java.util.*;

public class User {
    private long id;
    private String name;
    private int age;
    private List<String> activities;


    public User(long id, String name, int age, String... activities) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.activities = List.of(activities);
    }

    static Map<User, String> findHobbyLovers(
        List<User> users,
        String... activities
    ) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    @Override
    public String toString() {
        return name;
    }
}

