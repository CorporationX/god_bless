package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {

        if ((name == null) & (name.length() == 0)) {
            throw new IllegalArgumentException("Invalid name");
        } else if (age < 18) {
            throw new IllegalArgumentException("Invalid age");
        } else if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid placeOfWork");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    public static Map<Integer, List> groupUsers(List<User> users) {
        Map<Integer, List> usersByAge = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if (usersByAge.containsKey(userAge)) {
                usersByAge.get(userAge).add(user);
            } else {
                usersByAge.put(userAge, new ArrayList(Arrays.asList(user)));
            }
        }
        return usersByAge;
    }

    public int getAge() {
        return age;
    }
}
