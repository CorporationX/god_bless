package school.faang;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_OF_MAJORITY = 18;

    private int id;
    private String jobPlace;
    private String address;
    private String name;
    private int age;
    private Set<String> activities;


    public User(int id, String name, int age, Set<String> activities,
                String jobPlace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < AGE_OF_MAJORITY) {
            throw new IllegalArgumentException("Age cannot be less than 18 " +
                    "years");
        }
        if (!VALID_JOBS.contains(jobPlace)) {
            throw new IllegalArgumentException("Unacceptable place of work");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.id = id;
        this.jobPlace = jobPlace;
        this.address = address;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users,
                                                    Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        users.forEach(user -> user.activities.stream()
                .filter(activities -> targetActivities.contains(activities))
                .findFirst()
                .ifPresent(activities -> result.computeIfAbsent(user, v -> activities)));
        return result;
    }
}