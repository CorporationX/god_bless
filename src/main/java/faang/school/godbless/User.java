package faang.school.godbless;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class User {

    private String name;

    private Integer age;

    private String company;

    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {

        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            Integer userAge = user.getAge();

            if (!usersMap.containsKey(userAge)) {
                usersMap.put(userAge, new ArrayList<User>());
            }

            usersMap.get(userAge).add(user);
        }

        return usersMap;
    }
}
