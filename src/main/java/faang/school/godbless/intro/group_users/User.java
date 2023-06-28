package faang.school.godbless.intro.group_users;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(@NonNull String name, int age, @NonNull String workplace, @NonNull String address) {
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty or contain only spaces");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
    }

    private void validateWorkplace(String workplace) {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Incorrect value, workplace must be from the list");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect value, address must be from the list");
        }
    }

    public static Map<Integer, List<User>> groupUsers(@NonNull List<User> usersList) {
        return usersList.stream().filter(item -> item != null).collect(Collectors.groupingBy(User::getAge));
    }
}

