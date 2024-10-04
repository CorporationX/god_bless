package groupUsers;

import java.util.*;

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

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
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

        for (User user : users) {
            if (userGroups.containsKey(user.age)) {
                userGroups.get(user.age).add(user);
            } else {
                userGroups.put(user.age, new ArrayList<User>());
                userGroups.get(user.age).add(user);
            }
        }
        return userGroups;
    }
}
