package faang.school.godbless.group;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String workAddress;
    @NonNull
    private String homeAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        var userMap = new HashMap<Integer, List<User>>();
        for (User user : userList){
            addUser(userMap, user);
        }
        return userMap;
    }

    private static void addUser(Map<Integer, List<User>> userMap, User user) {
        userMap.computeIfAbsent(user.age, k -> new ArrayList<>());
        userMap.get(user.age).add(user);
    }
}
