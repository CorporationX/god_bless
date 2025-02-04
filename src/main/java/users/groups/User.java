package users.groups;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    @Override
    public String toString() {
        return String.format("User: name: %s, age: %d, workplace: %s, address: %s", name, age, workplace, address);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            List<User> userList = groupedUsers.get(user.getAge());
            if (userList != null) {
                groupedUsers.get(user.getAge()).add(user);
                continue;
            }
            userList = new ArrayList<>();
            userList.add(user);
            groupedUsers.put(user.getAge(), userList);
        }
        return groupedUsers;
    }
}
