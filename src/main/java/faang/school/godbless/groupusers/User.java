package faang.school.godbless.groupusers;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        validateInputs(name, age, placeOfWork, address);

        this.name = name;
        this.placeOfWork = placeOfWork;
        this.address = address;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    private void validateInputs(String name, int age, String placeOfWork, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
