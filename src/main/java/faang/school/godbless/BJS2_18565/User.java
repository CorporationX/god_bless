package faang.school.godbless.BJS2_18565;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers (List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if (userMap.containsKey(userAge)) {
                userMap.get(userAge).add(user);
            } else {
                userMap.put(userAge, new ArrayList<>(List.of(user)));
            }
        }
        return userMap;
    }
}
