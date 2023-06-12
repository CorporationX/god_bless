package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        if (Objects.equals(name, " ") || age < 18 || !VALID_JOBS.contains(company) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Some argument is incorrect");
        }
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int userAge = user.getAge();
            if (groupedUsers.containsKey(user.getAge())) {
                groupedUsers.get(userAge).add(user);
            } else {
                groupedUsers.put(userAge, new ArrayList<>(List.of(user)));
            }
        }
        return groupedUsers;
    }
}
