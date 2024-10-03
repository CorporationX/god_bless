package school.faang.bjs2_31543_user_registration;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int AGE_FOR_VALIDATION = 18;

    private String name;
    private String age;
    private String placeOfWork;
    private String address;

    public User(String name, String age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (Integer.parseInt(age) < AGE_FOR_VALIDATION) {
            throw new IllegalArgumentException("Age cannot be less than " + AGE_FOR_VALIDATION);
        } else if (!VALID_JOB.contains(placeOfWork)) {
            throw new IllegalArgumentException("You should choose a valid job : " + VALID_JOB);
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("You should choose a valid address : " + VALID_ADDRESSES);
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            userGroups.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }
}

