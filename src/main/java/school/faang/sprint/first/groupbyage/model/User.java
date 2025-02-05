package school.faang.sprint.first.groupbyage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String workplace;
    private String address;
    private int age;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (var user : users) {
            resultMap.computeIfAbsent(user.getAge(), u -> new ArrayList<>()).add(user);
        }

        return resultMap;
    }
}
