package faang.school.godbless.registration_users;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    private final HashSet<String> VALID_JOBS = new HashSet<>(
            Arrays.asList("Google", "Uber", "Amazon")
    );
    private final HashSet<String> VALID_ADDRESSES = new HashSet<>(
            Arrays.asList("London", "New York", "Amsterdam")
    );

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                    "Invalid input in user: " + name + ", " + age + ", " + placeOfWork + ", " + address
            );
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                List<User> usersByAge = new ArrayList<>();
                usersByAge.add(user);
                groupedUsers.put(user.getAge(), usersByAge);
            } else {
                groupedUsers.get(user.getAge()).add(user);
            }
        }

        return groupedUsers;
    }
}
