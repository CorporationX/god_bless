package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private final Set<String> VALID_JOBS = Set.of(
            "Google", "Uber", "Amazon"
    );
    private final Set<String> VALID_ADDRESSES = Set.of(
            "London", "New York", "Amsterdam"
    );

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            if (!usersMap.containsKey(user.age)) {
                usersMap.put(user.age, new ArrayList<>(List.of(user)));
            } else {
                usersMap.get(user.age).add(user);
            }
        }
        return usersMap;
    }
}
