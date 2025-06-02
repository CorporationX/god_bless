package school.faang.BJS2_79171;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {
    private final String name;
    private final int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageGroupMap = new HashMap<>();
        if (userList == null) {
            return ageGroupMap;
        }

        userList.forEach(user -> ageGroupMap.computeIfAbsent(user.age, age -> new ArrayList<>()).add(user));

        return ageGroupMap;
    }
}
