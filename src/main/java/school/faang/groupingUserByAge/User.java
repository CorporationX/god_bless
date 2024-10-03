package school.faang.groupingUserByAge;

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
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userGroupMap = new HashMap<>();
        userList.forEach(user -> userGroupMap.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user));
        return userGroupMap;
    }
}
