package faang.school.godbless.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User user : users) {
            int age = user.getAge();
            groupedUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

}
