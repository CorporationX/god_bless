package school.faang.task_BJS2_56323;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@AllArgsConstructor
@Getter

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<String, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<String, String> hobbyLovers = new HashMap<>();
        if (users == null || hobbies == null) {
            return hobbyLovers;
        }
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user.getName(), hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}