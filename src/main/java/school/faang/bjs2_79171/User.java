package school.faang.bjs2_79171;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> ageGroupMap = new HashMap<>();
        if (userList == null) {
            return ageGroupMap;
        }

        userList.forEach(user -> ageGroupMap.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user));

        return ageGroupMap;
    }
}
