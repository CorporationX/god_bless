package faang.school.godbless.agegrouping;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS =
            Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES =
            Set.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isBlank()
                || age < 18
                || workplace == null || !VALID_JOBS.contains(workplace)
                || address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException();
        }

        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            Integer age = user.getAge();
            usersMap.computeIfAbsent(age, key -> new ArrayList<>())
                    .add(user);
        }
        return usersMap;
    }
}