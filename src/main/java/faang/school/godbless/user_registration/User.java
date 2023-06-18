package faang.school.godbless.user_registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String jobLocation;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String jobLocation, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(jobLocation)) {
            throw new IllegalArgumentException("Неверное место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Неверный адрес");
        }
        this.name = name;
        this.age = age;
        this.jobLocation = jobLocation;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            List<User> usersGroup;
            if (!result.containsKey(user.age)) {
                usersGroup = new ArrayList<>();
            } else {
                usersGroup = result.get(user.age);
            }
            usersGroup.add(user);
            result.put(user.age, usersGroup);
        }
        return result;
    }
}