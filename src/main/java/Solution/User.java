package Solution;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {
    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, ArrayList> groupUsers(List<User> newUsers) {
        Map<Integer, ArrayList> ageGroup = new HashMap<>();

        for (User user : newUsers) {
            int age = user.getAge();
            ageGroup.putIfAbsent(age, new ArrayList<>());
            ageGroup.get(age).add(user);
        }
        return ageGroup;
    }

    public User(String name, int age, String placeOfWork, String address, Set<String> VALID_JOBS,
                Set<String> VALID_ADDRESSES) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }

        for (String user : VALID_JOBS) {

            if (user.contains(getPlaceOfWork())) {
                throw new IllegalArgumentException("Job already exists");
            }
        }
        for (String user : VALID_JOBS) {

            if (user.contains(getAddress())) {
                throw new IllegalArgumentException("Job already exists");
            }
        }

    }
}