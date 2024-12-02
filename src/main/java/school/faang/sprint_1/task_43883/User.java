package school.faang.sprint_1.task_43883;

import lombok.*;
import java.util.*;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groups = new HashMap<>();

        for (User user : users) {
            var ageKey = user.getAge();

            if (!groups.containsKey(ageKey)) {
                var newGroup = new ArrayList<User>();
                groups.put(ageKey, newGroup);
            }

            var group = groups.get(ageKey);
            group.add(user);
        }

        return groups;
    }
}
