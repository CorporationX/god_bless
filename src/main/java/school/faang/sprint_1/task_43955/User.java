package school.faang.sprint_1.task_43955;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> resultMap = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    resultMap.put(user, hobby);
                    break;
                }
            }
        }

        return resultMap;
    }
}
