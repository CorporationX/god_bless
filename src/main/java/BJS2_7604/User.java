package BJS2_7604;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        int currentAge;
        for (User user : users) {
            currentAge = user.getAge();
            groupedUsers.computeIfAbsent(currentAge, k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}
