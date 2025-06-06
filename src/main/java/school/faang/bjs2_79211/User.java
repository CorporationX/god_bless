package school.faang.bjs2_79211;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    @Getter
    private String name;
    @Getter
    private int age;


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : userList) {
            if (!resultMap.containsKey(user.getAge())) {
                resultMap.put(user.getAge(), new ArrayList<>());
            }
            resultMap.get(user.getAge()).add(user);

        }

        return resultMap;
    }
}
