package school.faang.task_43877;

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
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : users) {
            resultMap.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }

        return resultMap;
    }
}
