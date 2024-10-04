package school.faang;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedByAgeUsers = new HashMap<>();

        for (User user : users) {
            if (!sortedByAgeUsers.containsKey(user.age)) {
                sortedByAgeUsers.put(user.age, new ArrayList<>());
                sortedByAgeUsers.get(user.age).add(user);
            } else {
                sortedByAgeUsers.get(user.age).add(user);
            }
        }

        return sortedByAgeUsers;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + age + ", " + placeOfWork + ", " + address + "}";
    }
}
