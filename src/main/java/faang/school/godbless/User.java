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
    private String job;
    private String address;
    private int age;
    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet(Arrays.asList("London", "New York", "Amsterdam"));

    public int getAge() {
        return age;
    }

    public User(String name, String job, String address, int age) {
        if (name != null && VALID_JOBS.contains(job) && VALID_ADDRESSES.contains(address) && age >= 18) {
            this.name = name;
            this.job = job;
            this.address = address;
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if (result.containsKey(userAge)) {
                result.get(userAge).add(user);
            } else {
                List<User> s = new ArrayList<>();
                s.add(user);
                result.put(userAge, s);
            }
        }
        return result;
    }
}
