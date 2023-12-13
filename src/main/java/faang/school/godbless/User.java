package faang.school.godbless;

import java.util.*;

public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Enter your name");
        if (age < 18)
            throw new IllegalArgumentException("You are still young");
        if (!VALID_JOBS.contains(work))
            throw new IllegalArgumentException("Invalid workplace");
        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Invalid address");


        this.age = age;
        this.name = name;
        this.work = work;
        this.address = address;
    }

    static public Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            int userAge = user.getAge();
            groupedUsers.putIfAbsent(userAge, new ArrayList<>());
            groupedUsers.get(userAge).add(user);
        }
        return groupedUsers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}