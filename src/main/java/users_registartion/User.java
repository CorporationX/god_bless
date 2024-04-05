package users_registartion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Amazon", "Uber");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String work, String address) {
        if (name.isEmpty() || age <= 18 || !VALID_JOBS.contains(work) || !VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("One of the conditions is not met:(");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                groupedUsers.put(user.getAge(), new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }
}

