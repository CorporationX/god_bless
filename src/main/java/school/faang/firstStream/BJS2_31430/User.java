package school.faang.firstStream.BJS2_31430;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            usersGroupByAge.computeIfAbsent(age, value -> new ArrayList<>()).add(user);
        }
        return usersGroupByAge;
    }
}
