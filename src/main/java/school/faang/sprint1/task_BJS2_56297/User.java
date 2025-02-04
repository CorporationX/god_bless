package school.faang.sprint1.task_BJS2_56297;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> foundUsers = new HashMap<>();

        if (users.isEmpty() || hobbies.isEmpty()) {
            return foundUsers;
        }

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    foundUsers.put(user, hobby);
                    break;
                }
            }
        }
        return foundUsers;
    }
}
