package faang.school.godbless.usersGroupedByAge;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        } else if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        } else if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            List<User> usersList = groupedUsers.containsKey(user.age) ? groupedUsers.get(user.age) : new ArrayList<>();

            usersList.add(user);

            groupedUsers.put(user.age, usersList);
        }

        return groupedUsers;
    }
}
