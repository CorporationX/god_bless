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
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> usersByAgeMap = new HashMap<>();
        for (User user : userList) {
            if (!usersByAgeMap.containsKey(user.getAge())) {
                usersByAgeMap.put(user.getAge(), new ArrayList<>());
            }

            usersByAgeMap.get(user.getAge()).add(user);
        }

        return usersByAgeMap;
    }
}
