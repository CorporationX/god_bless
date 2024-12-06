package school.faang.sprint1.task_bjs2_44012;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(user);
        }
        return map;
    }

}
