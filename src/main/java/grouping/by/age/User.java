package grouping.by.age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User (String name, int age, String job, String address){
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age<18) {
            throw new IllegalArgumentException("На работу с 18 лет");
        }
        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException("Ты не можешь тут работать");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Ты не можешь тут жить");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapUser = new HashMap<>();
        for (User user:
             userList) {
            mapUser.computeIfAbsent(user.age, key -> new ArrayList<>()).add(user);
        }
        return mapUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
