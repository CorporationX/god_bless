package school.faang;

import lombok.Getter;
import java.util.*;

public class User {
    private Integer id;
    private String name;
    private  Integer age;

    @Getter
    private HashSet<String> activities;

    public User(Integer id, String name, Integer age, HashSet<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, HashSet<String> targetActivities) {
        Map<User, String> usersWithActivities = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (targetActivities.contains(activity)) {
                    usersWithActivities.put(user, activity);
                    break;
                }
            }
        }
        return usersWithActivities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name)
                && Objects.equals(age, user.age) && Objects.equals(activities, user.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities);
    }

    @Override
    public String toString() {
        return name;
    }
}
