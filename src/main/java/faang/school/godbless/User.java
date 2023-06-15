package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
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
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is blank");
        }
        if (age < 18) {
            throw new IllegalArgumentException("age < 18");
        }
        if(!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("wrong workplace");
        }
        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("wrong address");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            List<User> usersWithBirthdayInOneDay;
            if (!result.containsKey(user.age)) {
                usersWithBirthdayInOneDay = new ArrayList<>();
            } else {
                usersWithBirthdayInOneDay = result.get(user.age);
            }
            usersWithBirthdayInOneDay.add(user);
            result.put(user.age, usersWithBirthdayInOneDay);
        }
        return result;
    }
}
