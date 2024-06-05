package faang.school.godbless.usergrouping;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyMap;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private final String name;
    private final Integer age;
    private final String placeOfWork;
    private final String address;

    public User(String name, Integer age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;

        if (name == null || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return emptyMap();
    }

}
