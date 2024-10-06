package school.BJS2_29000;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {

    public final static Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public final static Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    public final static int MIN_AVAILABLE_AGE_FOR_USER = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    /* имя не может быть пустым;
       возраст не может быть меньше 18;
       место работы должно содержаться во множестве VALID_JOBS;
       адрес должен содержаться во множестве VALID_ADDRESSES.*/
    public User(String name, String address, String job, int age) {
        if (name == null) throw new IllegalArgumentException(name +" is null");
        if (age < MIN_AVAILABLE_AGE_FOR_USER) throw new IllegalArgumentException(age + " is smaller than 18");
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException(address + " is invalid");
        if (!VALID_JOBS.contains(job)) throw new IllegalArgumentException(job + " is invalid");
        else {
            this.address = address;
            this.age = age;
            this.name = name;
            this.job = job;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return userGroups;
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