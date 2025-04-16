package school.faang.collecting;

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
        Map<User, String> groupedByHobby = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbies.contains(hobby)) {
                    groupedByHobby.put(user, hobby);

                }
            }
        }
        return groupedByHobby;
    }
}
