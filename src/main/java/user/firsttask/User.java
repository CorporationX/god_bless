package user.firsttask;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {

    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int MIN_AGE_FOR_REGISTER = 18;
    private String name;
    private int age;
    private String placeOfWork;
    private String address;


    public User(String name, int age, String placeOfWork, String address) {
        if ((name == null || name.isBlank()) ||
            (age < MIN_AGE_FOR_REGISTER) ||
            (!VALID_ADDRESSES.contains(address)) ||
            (!VALID_JOBS.contains(placeOfWork))) {
            throw new IllegalArgumentException("Invalid user data");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static HashMap<Integer, List<User>> sortingUsersByAge(List<User> users) {
        HashMap<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            usersByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            usersByAge.get(user.getAge()).add(user);
        }
        return usersByAge;
    }
}
