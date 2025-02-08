package BJS2_56384;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                }
            }
        }

        return hobbyLovers;
    }
}
