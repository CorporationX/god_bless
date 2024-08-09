package faang.school.godbless.collecting_users;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@ToString
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(activities, user.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities);
    }

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activitySet) {
        Map<User, String> userMap = new HashMap<>();

        for (User user : userList) {
            for (String activity : activitySet) {
                if (user.activities.contains(activity)) {
                    userMap.put(user, activity);
                    break;
                }
            }
        }
        for (Map.Entry<User, String> entry : userMap.entrySet()) {
            System.out.println("Key > " + entry.getKey() + " - value > " + entry.getValue());
        }

        return userMap;
    }
}
