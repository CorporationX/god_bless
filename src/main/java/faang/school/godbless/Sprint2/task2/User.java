package faang.school.godbless.Sprint2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String corporation;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_LIMIT = 18;

    public User(String name, int age, String corporation, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Enter your name please");
        }
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("You're not old enough");
        }
        if (!VALID_JOBS.contains(corporation)) {
            throw new IllegalArgumentException("Job location is incorrect");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is incorrect");
        }
        this.name = name;
        this.age = age;
        this.corporation = corporation;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.age;
            if (groupMap.containsKey(user.age)) {
                groupMap.get(userAge).add(user);
            } else {
                List<User> group = new ArrayList<>();
                group.add(user);
                groupMap.put(user.age, group);
            }
        }
        return groupMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", corporation='" + corporation + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
