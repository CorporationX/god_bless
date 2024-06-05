package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public static final Set VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + " Illigal name");
        }

        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(age + " is Illigal age");
        }

        if (VALID_JOBS.contains(workPlace)) {
            this.workPlace = workPlace;
        } else {
            throw new IllegalArgumentException(workPlace + " is Illigal work place");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException(address + " is Illigal address");
        }
    }

    @Override
    public String toString() {
        return name + " " + age + " " + workPlace + " " + address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userData) {
        Map<Integer, List<User>> result = new HashMap<>();
        List<User> users;

        for (User user : userData) {
            if (!result.containsKey(user.getAge())) {
                users = new ArrayList<>();
                users.add(user);
                result.put(user.age, users);
            }
            else {
                users = result.get(user.age);
                users.add(user);
            }
        }
        return result;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getWorkPlace() {
        return this.workPlace;
    }

    public String getAddress() {
        return this.address;
    }
}