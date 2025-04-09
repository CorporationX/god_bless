package school.faang.collect_users;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> list, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (String hobby : hobbies) {
            for (User user : list) {
                if (user.getHobbies().contains(hobby)) {
                    hobbyLovers.putIfAbsent(user, hobby);
                }
            }
        }

        return hobbyLovers;
    }
}
