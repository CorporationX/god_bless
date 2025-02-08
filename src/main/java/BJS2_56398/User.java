package BJS2_56398;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    /**
     * @param users - list of users
     * @return - map where key is age and value is list of users with that age
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        if (users == null) {
            return groupedUsers;
        }

        for (User user : users) {
            groupedUsers.putIfAbsent(user.age, new ArrayList<>());
            groupedUsers.get(user.age).add(user);
        }

        return groupedUsers;
    }
}