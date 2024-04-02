package faang.school.godbless.bjs2_4211;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {

    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String jobPlace;
    private String address;

    public User(String name, int age, String jobPlace, String address) {
        if (name.isBlank() || name.isEmpty() || age < 18 || !VALID_JOBS.contains(jobPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.jobPlace = jobPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupMapUsers = new HashMap<>();

        for (User user : users) {
            List<User> groupListUsers = new ArrayList<>();
            groupListUsers.add(user);
            groupMapUsers.putIfAbsent(user.age, groupListUsers);
            groupMapUsers.computeIfPresent(user.age, (key, value) -> {
                if (!value.contains(user)) {
                    value.add(user);
                }
                return value;
            });
        }
        return groupMapUsers;
    }
}
