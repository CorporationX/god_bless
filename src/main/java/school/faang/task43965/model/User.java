package school.faang.task43965.model;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private final String id;
    private final String name;
    private final int age;
    private Set<String> activities = new HashSet<>();

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addActivities(Set<String> activities) {
        this.activities.addAll(activities);
    }

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> selectedUsers = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    selectedUsers.put(user, activity);
                    break;
                }
            }
        }
        return selectedUsers;
    }

}