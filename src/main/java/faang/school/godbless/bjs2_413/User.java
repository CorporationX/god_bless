package faang.school.godbless.bjs2_413;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@Builder
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            if (!usersByAge.containsKey(user.getAge())) {
                usersByAge.put(user.getAge(), new ArrayList<User>());
            }
            usersByAge.get(user.getAge()).add(user);
        }
        return usersByAge;
    }
}