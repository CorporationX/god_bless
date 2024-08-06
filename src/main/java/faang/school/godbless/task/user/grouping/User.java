package faang.school.godbless.task.user.grouping;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfJob;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if(users == null) {
            return null;
        }
        Map<Integer, List<User>> ageUserMap = new HashMap<>();
        users.forEach(user -> ageUserMap.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));

        return ageUserMap;
    }
}
