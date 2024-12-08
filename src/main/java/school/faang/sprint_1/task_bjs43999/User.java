package school.faang.sprint_1.task_bjs43999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
    private String workName;
    private String workAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> map = new HashMap<>();

        for (User user : userList) {
            List<User> usersByAge = map.get(user.getAge());
            if (usersByAge != null) {
                usersByAge.add(user);
            } else {
                usersByAge = new ArrayList<>();
                usersByAge.add(user);
                map.put(user.getAge(), usersByAge);
            }
        }
        return map;
    }
}