package faang.school.godbless.BJS2_18440;

import java.util.*;

public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public User(long id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.activities.contains(activity)) {
                    map.put(user, activity);
                }
            }
        }

        return map;
    }

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

    @Override
    public String toString() {
        return
                name + '\'' + age;
    }
}