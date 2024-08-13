package faang.school.godbless.BJS2_18565;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public static Map<Integer, List<User>> groupUsers (List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.age;
            if (userMap.containsKey(userAge)) {
                userMap.get(userAge).add(user);
            } else {
                userMap.put(userAge, new ArrayList<>(List.of(user)));
            }
        }
        return userMap;
    }
}
