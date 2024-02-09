package faang.school.godbless.group.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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


    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        User user = (User) object;
        return this.id == user.id && Objects.equals(this.name, user.name) && this.age == user.id && Objects.equals(this.activities, user.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activities);
    }

    public static Map<User, String> createMapWithUsers(List<User> users, Set<String> activities) {
        Map<User, String> usersWithActivities = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)) {
                    usersWithActivities.put(user, activity);
                    break;
                }
            }
        }
        return usersWithActivities;
    }
}
