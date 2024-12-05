package school.faang.s12task43925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> newUsers = new ArrayList<>();
                newUsers.add(user);
                groupedUsers.put(age, newUsers);
            }
            //    groupedUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user); // this is instead if-else
        }
        return groupedUsers;
    }
}