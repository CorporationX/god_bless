package users.group.by.age;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_VALID_AGE = 18;
    private final String name;
    private final String workPlace;
    private final String address;
    private final int age;
  
    public User(String name, String workPlace, String address, int age) {
        if (name.isBlank() || age < MIN_VALID_AGE || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.workPlace = workPlace;
        this.address = address;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.age)) {
                List<User> oneUserInList = new ArrayList<>();
                oneUserInList.add(user);
                groupedUsers.put(user.age, oneUserInList);
            }

            groupedUsers.get(user.age).add(user);
        }

        return groupedUsers;
    }
}
