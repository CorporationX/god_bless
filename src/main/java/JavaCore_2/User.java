package JavaCore_2;

import java.util.*;

public class User {

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if ((name != null) && (!name.isBlank()) && (age >= 18) && (VALID_JOBS.equals(job)) && (VALID_ADDRESSES.equals(address))) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException("The entered data is incorrect");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroups = new HashMap<>();
        for (User user : users) {
            if (!(usersGroups.containsKey(user.getAge()))) {
                usersGroups.put(user.getAge(), new ArrayList<>());
            }
            usersGroups.get(user.getAge()).add(user);
        }
        return usersGroups;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

}