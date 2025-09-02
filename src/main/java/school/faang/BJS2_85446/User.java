package school.faang.BJS2_85446;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.List;

@ToString(includeFieldNames = true)
@AllArgsConstructor
public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            Optional<String> hobby = user.hobbies.stream().filter(hobbies::contains).findAny();
            hobby.ifPresent(s -> result.put(user, s));
        }
        return result;
    }
}
