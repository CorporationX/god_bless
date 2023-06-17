package faang.school.godbless.firstSprint.second;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            usersByAge.putIfAbsent(user.age, new ArrayList<>());
            usersByAge.get(user.age).add(user);
        }
        return usersByAge;
    }

    public User(String name, int age, String workplace, String address) {
        ParameterValidation.validateParameters(name, age, workplace, VALID_JOBS, address, VALID_ADDRESSES);
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}
