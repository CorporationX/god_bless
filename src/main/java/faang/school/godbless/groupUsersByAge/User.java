package faang.school.godbless.groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public static Map<Integer, List<User>> groupUser(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        if (userList != null) {

            for (User user : userList) {
                userMap.computeIfAbsent(user.getAge(), u -> new ArrayList<>()).add(user);
            }
        }
        return userMap;
    }
}