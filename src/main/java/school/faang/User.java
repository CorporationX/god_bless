package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()
                || age < 18
                || !VALID_JOBS.contains(job)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid inputs");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> usersList) {
        HashMap<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : usersList) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}