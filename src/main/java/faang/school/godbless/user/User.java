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
    private  String name;
    private int age;
    private UUID id;
    private Set<String> activities;
    private String workplace;
    private String address;

    public User(String name, int age, Set<String> activities, String workplace, String address) throws IllegalArgumentException {
        if (name == "") {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < 18) {
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

    public int getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }

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
        for (User user: users) {
            if (map.containsKey(user.age)) {
                map.get(user.age).add(user);
            } else {
                List<User> arr = new ArrayList<>();
                arr.add(user);
                map.put(user.age, arr);
            }
        }
        return map;
    }

    public static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList( "Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList( "London", "New York", "Amsterdam"));

    @Override
    public String toString() {
        return this.name + "(" + this.age + ")";
    }
}