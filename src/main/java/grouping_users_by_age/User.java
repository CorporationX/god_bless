package grouping_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String placeOfWorking;
    private String address;

    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWorking, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(placeOfWorking)) {
            throw new IllegalArgumentException("Invalid place of working");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.placeOfWorking = placeOfWorking;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return usersByAge;
    }
}
