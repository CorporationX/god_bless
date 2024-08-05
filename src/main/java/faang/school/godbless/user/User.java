package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class User {
    public static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            map.computeIfAbsent(user.age, (k) -> new ArrayList<>()).add(user);
        }
        return map;
    }

    public static int LEGAL_AGE = 18;

    private final String name;
    private final int age;
    private final UUID id;
    private final Set<String> activities;
    private final String workplace;
    private final String address;

    public User(String name, int age, Set<String> activities, String workplace, String address)
            throws IllegalArgumentException {
        if (name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
        this.activities = activities;
        this.address = address;
        this.workplace = workplace;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.age + ")";
    }
}