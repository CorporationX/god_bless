package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private int age;
    private Set<String> hobbies;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        var hobbyLovers = new HashMap<User, String>();
        users.forEach(user -> {
            hobbies.retainAll(user.getHobbies());
            hobbyLovers.put(user, hobbies.stream().findAny().orElse("Doesn't have matched hobbies"));
        });
        return hobbyLovers;
    }
}
