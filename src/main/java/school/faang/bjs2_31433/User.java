package school.faang.bjs2_31433;

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
            sortedByAgeUsers.putIfAbsent(user.age, new ArrayList<>());
            sortedByAgeUsers.get(user.age).add(user);
        }

        return sortedByAgeUsers;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + age + ", " + placeOfWork + ", " + address + "}";
    }
}
