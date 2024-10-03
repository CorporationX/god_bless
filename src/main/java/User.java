import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class User {
    private static final List<String> VALID_JOBS = new ArrayList<String>(Arrays.asList(
            "Google", "Uber", "Amazon"
    ));
    private static final List<String> VALID_ADDRESSES = new ArrayList<>(Arrays.asList(
            "London", "New York", "Amsterdam"
    ));
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    User(String name, int age, String placeOfWork, String address) {
        if ("".equals(name) || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("parameters don't correct");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User u : users) {
            groupedUsersByAge.computeIfAbsent(u.getAge(), k -> new ArrayList<User>()).add(u);
        }
        return groupedUsersByAge;
    }
}
