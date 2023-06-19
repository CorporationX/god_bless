package faang.school.godbless.UserRegistration;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "NewYork", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;


    public User(String name, int age, String workPlace, String address) {
        if (!(name != null || name.isEmpty())) {
            throw new IllegalArgumentException("Name is blank");
        }
        if (!(age >= MIN_AGE)) {
            throw new IllegalArgumentException("Children can't work");
        }
        if (!(VALID_JOBS.contains(workPlace))) {
            throw new IllegalArgumentException("Not valid workplace");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Not valid address");
        }
        this.name = name;
        this.address = address;
        this.age = age;
        this.workPlace = workPlace;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            groupUsers.putIfAbsent(user.age, new ArrayList<>());
            groupUsers.get(user.age).add(user);
        }
        return groupUsers;
    }
}
