package faang.school.godbless.UserRegistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    private final static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private final static byte VALID_AGE = 18;

    public User(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
        checkUser(this);
    }

    public void checkUser(User user) {
        if (user.name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }
        if (user.age < VALID_AGE) {
            throw new IllegalArgumentException("Age can't be under 18");
        }
        if (!VALID_JOBS.contains(user.work)) {
            throw new IllegalArgumentException("Not valid job");
        }
        if (!VALID_ADDRESSES.contains(user.address)) {
            throw new IllegalArgumentException("Not valid address");
        }
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> resultMap = new HashMap<>();
        for (User user : userList) {
            resultMap.computeIfAbsent(user.getAge(),k -> new ArrayList<>()).add(user);
        }
        return resultMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                "}";
    }
}
