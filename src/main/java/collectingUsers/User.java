package collectingUsers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class User {
    private static int count = 0;

    private final int id;
    private final String name;
    private final Set<String> hobbyLovers;

    public User(String name, Set<String> hobbyLovers) {
        this.name = name;
        this.hobbyLovers = hobbyLovers;
        this.id = ++count;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getHobbyLovers().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }

}
