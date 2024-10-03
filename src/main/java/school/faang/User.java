package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final Integer VALID_AGE = 18;

    private String name;
    private String address;
    private String job;
    private int age;

    public User(String name, String address, String job, int age) {
        if (name.isBlank() || !VALID_ADDRESSES.contains(address) || age < VALID_AGE || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.address = address;
            this.job = job;
            this.age = age;
        }
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            result.computeIfAbsent(user.getAge(), u -> new ArrayList<>()).add(user);
        }
        return result;
    }
}
