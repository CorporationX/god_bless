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
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String placeOfWork, String address) {
        boolean isValidName = (name != null) & (name.length() > 0);
        boolean isValidAge = age >= 18;
        boolean isValidPOW = VALID_JOBS.contains(placeOfWork);
        boolean isValidAddress = VALID_ADDRESSES.contains(address);

        if (isValidName & isValidAge & isValidPOW & isValidAddress) {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        } else if (!isValidName) {
            throw new IllegalArgumentException("Invalid name");
        } else if (!isValidAge) {
            throw new IllegalArgumentException("Invalid age");
        } else if (!isValidPOW) {
            throw new IllegalArgumentException("Invalid placeOfWork");
        } else {
            throw new IllegalArgumentException("Invalid address");
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
