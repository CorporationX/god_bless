package user.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    private static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;

    public User(@NonNull String name, int age, @NonNull String workPlace, @NonNull String address) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Incorrect name");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Incorrect age");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Incorrect work place");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect address");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(@NonNull List<User> users) {
        Map<Integer, List<User>> userAges = new HashMap<>();
        for(User user : users) {
            if (!userAges.containsKey(user.getAge())) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userAges.put(user.getAge(), userList);
            }
            else {
                userAges.get(user.getAge()).add(user);
            }
        }

        return userAges;
    }
}
