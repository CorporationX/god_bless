package faang.school.godbless.register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;

    public User(String name, int age, String workPlace, String address) {
        validateName(name);
        validateAge(age);
        validateWorkPlace(workPlace);
        validateAddress(address);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("incorrect address");
        }
    }

    private void validateWorkPlace(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("incorrect workplace");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("incorrect age");
        }
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("incorrect name");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAge = new HashMap<>();
        for (var user : users) {
            int age = user.getAge();
            groupedByAge.computeIfAbsent(age, k -> new ArrayList<User>()).add(user);
        }
        return groupedByAge;
    }
}
