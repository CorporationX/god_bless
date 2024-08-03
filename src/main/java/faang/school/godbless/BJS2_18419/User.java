package faang.school.godbless.BJS2_18419;


import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String address;
    private String workPlace;

    public User(String name, int age, String workPlace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }

        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Work Place is not valid");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupsByAge = new HashMap<>();
        for (User user : users) {
            List<User> userListByAge = users.stream().filter(s -> s.getAge() == user.getAge()).toList();
            userGroupsByAge.put(user.getAge(), userListByAge);
        }
        return userGroupsByAge;
    }
}

