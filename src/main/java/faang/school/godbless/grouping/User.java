package faang.school.godbless.grouping;

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
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();

            if (usersByAge.containsKey(age)) {
                List<User> existingUserList = usersByAge.get(age);
                existingUserList.add(user);
                usersByAge.put(age, existingUserList);
            } else {
                List<User> usersThisAge = new ArrayList<>();
                usersThisAge.add(user);
                usersByAge.put(age, usersThisAge);
            }
        }
        return usersByAge;
    }
}
