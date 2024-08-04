package faang.school.godbless.BJS2_18433;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {

//        if(name == null || name.isEmpty() || age < 18 || !VALID_ADDRESSES.contains(address) || VALID_JOBS.contains(job)) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    public String getName() {
        return name;
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
