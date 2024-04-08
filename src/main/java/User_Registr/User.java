package User_Registr;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    final private static int LEGAL_AGE = 18;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();
        for (User user : userList) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }
            userMap.get(user.getAge()).add(user);
        }
        return userMap;
    }

    public User() {

    }

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Fancy name");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("Too young – " + name);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Poor job – " + name);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Unacceptable address – " + name);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void setAge(int age) {
        if (age < LEGAL_AGE)
            throw new IllegalArgumentException("Too young – "+name);
        this.age = age;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Fancy name");
        }
        this.name = name;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Poor job – "+name);
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Unacceptable address – "+name);
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n" + "Name – " + name +
                ", Job – " + job +
                ", Address – " + address;
    }
}