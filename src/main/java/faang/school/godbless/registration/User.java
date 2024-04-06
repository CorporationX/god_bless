package faang.school.godbless.registration;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final List<String> VALID_JOBS =
            new ArrayList<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final List<String> VALID_ADDRESSES =
            new ArrayList<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job is not valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }

//        boolean condition = name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address);
//        if (condition){
//            throw new IllegalArgumentException();
//        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            int age = user.age;
            if (!group.containsKey(age)) {
                group.put(age, new ArrayList<>());
            }
            group.get(age).add(user);
        }
        return group;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}
