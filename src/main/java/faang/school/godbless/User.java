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

    private String name;
    private int age;
    private String companyName;
    private String adress;

    public User(String name, int age, String companyName, String adress) throws IllegalArgumentException {
        if (name.isEmpty() || age < 18 || !VALID_ADDRESSES.contains(companyName) || !VALID_JOBS.contains(adress)){
            throw new IllegalArgumentException("Wrong arguments");
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
