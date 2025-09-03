package school.faang.user_grouping_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
@Getter
public class User {
    private final String name;
    private final Integer age;
    private final String workplace;
    private final String address;

    protected static Map<Integer, List<User>> groupUsers(List<User> listOfUsers) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : listOfUsers) {
            int age = user.getAge();
            result.computeIfAbsent(age, k -> new ArrayList<>());
            result.get(age).add(user);
        }

        return result;
    }
}
