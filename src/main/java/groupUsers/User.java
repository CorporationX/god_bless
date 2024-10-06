package groupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final static Set<String> VALID_JOBS = new HashSet<String>() {{
        add("Google");
        add("Uber");
        add("Amazon");
    }};
    private final static Set<String> VALID_ADDRESSES = new HashSet<String>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};
    private final static int MINIMAL_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MINIMAL_AGE) {
            throw new IllegalArgumentException("Возраст %d меньше %d".formatted(age, MINIMAL_AGE));
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        users.forEach(user -> {
            userGroups.putIfAbsent(user.age, new ArrayList<>());
            userGroups.get(user.age).add(user);
        });

        return userGroups;
    }
}
