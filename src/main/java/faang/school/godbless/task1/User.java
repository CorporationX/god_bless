package faang.school.godbless.task1;


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
    private String workPlace;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workPlace, String address) {
        validateName(name);
        validateAge(age);
        validateWorkPlace(workPlace);
        validateAddresses(address);

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWorkPlace(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAddresses(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        Map<Integer, List<User>> sortByAge = new HashMap<>();
        for (User user : listUsers) {
            sortByAge.computeIfAbsent(user.getAge(), c -> new ArrayList<>()).add(user);
        }
        return sortByAge;
    }
}
