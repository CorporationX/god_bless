package Collect;

import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(String name, Set<String> activities) {
        this.name = name;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> answer = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    answer.put(user, activity);
                    break;
                }
            }
        }
        return answer;
    }

    public Set<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }
}
