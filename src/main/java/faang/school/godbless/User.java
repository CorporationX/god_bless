package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@AllArgsConstructor @Getter @ToString @NonNull
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;


    public static Map<Integer, ArrayList<User>> groupUsers(List<User> userList) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();

        if (userList != null) {
            for (var user: userList) {
                userMap.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
            }
        }

        return userMap;
    }
}