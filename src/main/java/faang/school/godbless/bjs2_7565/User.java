package faang.school.godbless.bjs2_7565;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid workplace");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        if (users != null) {
            userGroups = users.stream()
                    .collect(Collectors.groupingBy(User::getAge));
        }
        return userGroups;
    }
}
