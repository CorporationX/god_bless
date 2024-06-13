package faang.school.godbless;

import java.sql.SQLOutput;
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
    private final int MAJORITY = 18;

    public int getAge() {
        return this.age;
    }

    public User(String name, String job, String address, int age) {
        if (name != null) {
            this.name = name;
            if (VALID_JOBS.contains(job)) {
                this.job = job;
                if (VALID_ADDRESSES.contains(address)) {
                    this.address = address;
                        if (age >= MAJORITY) {
                            this.age = age;
                        } else {
                        throw new IllegalArgumentException("Age is not majority");
                        }
                } else {
                    throw new IllegalArgumentException("address not listed");
                }
            } else {
                throw new IllegalArgumentException("job not listed");
            }
        } else {
            throw new IllegalArgumentException("name not specified");
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
