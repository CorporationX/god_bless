package SortByAge;

import lombok.Getter;

import java.util.*;

@Getter

public class User {
    private static final Set<String> VALID_JOBS;
    private static final Set<String> VALID_ADDRESSES;

    private String name;
    private int age;
    private String workplace;
    private String address;

    static {
        VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    }

    public User(String name, int age, String workplace, String address) {
        setName(name);
        setAge(age);
        setWorkplace(workplace);
        setAddress(address);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> mapOfPeers = new HashMap<>();
        for (User user : users) {
            mapOfPeers.putIfAbsent(user.getAge(), new ArrayList<>());
            mapOfPeers.get(user.getAge()).add(user);
        }
        return mapOfPeers;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        this.age = age;
    }

    public void setWorkplace(String workplace) throws IllegalArgumentException {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Provided job is not in our list");
        }
        this.workplace = workplace;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Provided address is not in our list");
        }
        this.address = address;
    }
}
