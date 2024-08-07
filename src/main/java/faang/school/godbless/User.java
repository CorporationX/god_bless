package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id, age;
    private String name;
    private Set<String> activities;

    public User(int id, int age, String name, Set<String> activities) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.activities = activities;
    }

    public Set<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> collectionUsers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    collectionUsers.put(user, activity);
                }
                break;
            }
        }
        return collectionUsers;
    }
}
