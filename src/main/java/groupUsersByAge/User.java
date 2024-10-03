package groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (user.getAge() < 1) {
                throw new IllegalArgumentException("Incorrect age value");
            }
            if (groupedUsers.containsKey(user.getAge())) {
                groupedUsers.get(user.getAge()).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupedUsers.put(user.getAge(), userList);
            }
        }
        return groupedUsers;
    }
}
