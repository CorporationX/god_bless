package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@AllArgsConstructor @Getter @ToString
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;


    public static Map<Integer, ArrayList<User>> groupUsers(List<User> userList) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();

        for (var user: userList) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }

            userMap.get(user.getAge()).add(user);
        }

        return userMap;
    }
}