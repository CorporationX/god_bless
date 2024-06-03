package faang.school.godbless.agegrouping;

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
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            Integer age = user.getAge();

            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(user);
            } else {
                List<User> usersSameAge = new ArrayList<>();
                usersSameAge.add(user);
                usersMap.put(age, usersSameAge);
            }
        }
        return usersMap;
    }
}