package school.faang.sprint_1.task_44053;

import lombok.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Value
public class User {
    int id;
    String name;
    int age;
    Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> userHobby = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbies().contains(hobby)) {
                    userHobby.put(user, hobby);
                }
            }
        }
        return userHobby;
    }
}
