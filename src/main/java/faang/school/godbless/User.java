package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("User name null or blank");
        }
        if (age < 18) {
            throw new IllegalArgumentException("User age is not valid");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("User workPlace is not valid");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("User address is not valid");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                "}";
    }

    public static Map<Integer, List<User>> group(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            groupedUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void printGrouped(Map<Integer, List<User>> groupedList) {
        for (Map.Entry<Integer, List<User>> listEntry : groupedList.entrySet()) {
            System.out.println("Users with age " + listEntry.getKey());
            for (User user : listEntry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
