package faang.school.godbless.bjs218447;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String name;
    int age;
    String workPlace;
    String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            if (userGroups.containsKey(user.getAge())) {
                userGroups.get(user.getAge()).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userGroups.put(user.getAge(), userList);
            }
        }
        return userGroups;
    }
}
