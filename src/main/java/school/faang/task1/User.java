package school.faang.task1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static final Set<String> VALID_JOBS = new HashSet<>() {{
        add("Google");
        add("Uber");
        add("Amazon");
    }};

    public static final Set<String> VALID_ADDRESSES = new HashSet<>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};

    public User(String name, int age, String workPlace, String address) {
        setName(name);
        setAge(age);
        setWorkPlace(workPlace);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age should not be less than 18");
        }
        this.age = age;
    }

    public void setWorkPlace(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Job is invalid. Valid jobs are: " + VALID_JOBS);
        }
        this.workPlace = workPlace;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is invalid. Valid address in: " + VALID_ADDRESSES);
        }
        this.address = address;
    }

    public static void addUserToList(List<User> users, User user) {
        users.add(user);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new TreeMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void printGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        System.out.println("USERS GROUPED BY AGE");
        for (Integer age : groupedUsers.keySet()) {
            System.out.println("Age:" + age);
            for (User user : groupedUsers.get(age)) {
                System.out.println("\t" + user);
            }
        }
    }
}
