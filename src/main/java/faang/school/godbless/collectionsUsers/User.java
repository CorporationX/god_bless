package faang.school.godbless.collectionsUsers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode
@Getter
@ToString(includeFieldNames = false)
public class User {
    private static final int MIN_AGE = 18;
    private static AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(String name, int age, Set<String> activities) {
        if (name.isBlank() ||
                age < MIN_AGE) {
            throw new IllegalArgumentException("Incorrect data for user initialize");
        }
        this.id = nextId.getAndIncrement();
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userHobby = new HashMap<>();
        for (User user : users) {
            String matchedActivity = user.findMatchActivity(activities);
            if (!matchedActivity.isBlank()) {
                userHobby.put(user, matchedActivity);
            }
        }
        return userHobby;
    }

    public static void resetNextId() {
        nextId.set(0);
    }

    private String findMatchActivity(Set<String> activities) {
        for (String activity : activities) {
            if (this.activities.contains(activity)) {
                return activity;
            }
        }
        return "";
    }
}
