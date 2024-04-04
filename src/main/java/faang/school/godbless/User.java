package faang.school.godbless;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;

@Data
@NoArgsConstructor
public class User {
    public static void main(String[] args) {

    }

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name != null
                && age >= 18
                && VALID_JOBS.contains(job)
                && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public Map<Integer, User> groupUsers(List<User> users) {
        Map<Integer, User> usersMap = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            usersMap.put(users.get(i).getAge(), users.get(i));
        }
        return usersMap;
    }

}
