package user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupsMap = new HashMap<>();
        for (User user : users) {
            userGroupsMap.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }
        return userGroupsMap;
    }
}
