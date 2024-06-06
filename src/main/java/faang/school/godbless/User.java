package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static final String[] ADDRESSES = {"London", "New York", "Amsterdam"};
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList(ADDRESSES));
    private static final String[] JOBS = {"Google", "Uber", "Amazon"};
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList(JOBS));
    private static final int CRITICAL_AGE = 18;

    private String name;
    private int age;
    private String companyName;
    private String adress;

    public User(String name, int age, String companyName, String adress)  {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (age < CRITICAL_AGE) {
            throw new IllegalArgumentException("Must be greater than or equal to 18 years of age");
        }
        if (!VALID_JOBS.contains(companyName)) {
            throw new IllegalArgumentException("The name of the company is invalid");
        }
        if (!VALID_ADDRESSES.contains(adress)) {
            throw new IllegalArgumentException("The adress of the company is invalid");
        }
        this.name = name;
        this.age = age;
        this.companyName = companyName;
        this.adress = adress;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            if (result.containsKey(user.getAge())) {
                List<User> currentUsers = result.get(user.getAge());
                currentUsers.add(user);
                result.replace(user.getAge(), currentUsers);
            } else {
                List<User> newUser = new ArrayList<>();
                newUser.add(user);
                result.put(user.getAge(), newUser);
            }
        }
        return result;
    }

}
