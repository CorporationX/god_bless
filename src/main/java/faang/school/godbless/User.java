package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (groupedUsers.containsKey(user.getAge())) {
                groupedUsers.get(user.getAge()).add(user);
            } else {
                List<User> usersList = new ArrayList<>();
                usersList.add(user);
                groupedUsers.put(user.getAge(), usersList);
            }
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
