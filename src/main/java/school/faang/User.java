package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            usersGroupedByAge.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return usersGroupedByAge;
    }
}
