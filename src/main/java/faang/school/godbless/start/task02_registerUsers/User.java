package faang.school.godbless.start.task02_registerUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        checkName(name);
        checkAge(age);
        checkJobs(workplace);
        checkAddress(address);
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(user);
        }
        return map;
    }

    public void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty!");
        }
    }

    public void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Employee under 18");
        }
    }

    public void checkJobs(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid job");
        }
    }

    public void checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
    public int getAge() {
        return age;
    }
}
