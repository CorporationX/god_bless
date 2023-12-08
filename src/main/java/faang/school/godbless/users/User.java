package faang.school.godbless.users;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String workplace, String address) {
        validateUserInput(name, age, workplace, address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = users.stream()
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.toList()));

        return usersGroupByAge;
    }

    private static void validateUserInput(
            final String name,
            final int age,
            final String workplace,
            final String address) {
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);
    }

    private static void validateName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Fill the name field, please.");
        }
    }

    private static void validateAge(final int age) {
        if (age < 18) {
            throw new IllegalArgumentException("You're too young for this, bud");
        }
    }

    private static void validateWorkplace(final String workplace) {
        if (workplace == null || !VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("You're not allowed to work here!");
        }
    }

    private static void validateAddress(final String address) {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("You're not allowed to live here!");
        }
    }
}
