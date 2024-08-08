package BJS2_18430;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@ToString
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;

    public User(int id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> allActivities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getUserActivities()) {
                if (allActivities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public Set<String> getUserActivities() {
        return userActivities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(getUserActivities(), user.getUserActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, getUserActivities());
    }
}
