package school.faang.BJS2_43967;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String name;
    int age;
    String workPlace;
    String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAgeMap = new HashMap<>();

        for (var user : users) {
            int age = user.getAge();

            if (usersByAgeMap.containsKey(age)) {
                usersByAgeMap.get(age).add(user);
            } else {
                List<User> usersByAge = new ArrayList<>();
                usersByAge.add(user);
                usersByAgeMap.put(age, usersByAge);
            }
        }

        return usersByAgeMap;
    }

}
