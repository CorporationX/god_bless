package school.faang;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(int id, String name, int age, Set<String> activities, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("The age cannot be less than 18 years old");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The place of work must be one of: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be one of:: " + VALID_ADDRESSES);
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
        this.job = job;
        this.address = address;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            User user1 = new User(1, "Alice", 30, new HashSet<>(Arrays.asList("reading", "swimming")), "Google", "London");
            User user2 = new User(2, "Bob", 25, new HashSet<>(Arrays.asList("running", "swimming")), "Uber", "New York");
            User user3 = new User(3, "Charlie", 35, new HashSet<>(Arrays.asList("cycling", "reading")), "Amazon", "Amsterdam");

            List<User> users = Arrays.asList(user1, user2, user3);
            Set<String> hobbies = new HashSet<>(Arrays.asList("swimming", "cycling"));

            Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

            hobbyLovers.forEach((user, hobby) ->
                    System.out.println("User: " + user.getName() + ", Hobby: " + hobby)
            );
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
