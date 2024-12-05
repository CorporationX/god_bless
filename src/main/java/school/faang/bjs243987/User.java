package school.faang.bjs243987;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private final String name;
    private final int age;
    private final int id;
    private final Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            user.getHobbies().stream()
                    .filter(hobbies::contains)
                    .findFirst()
                    .ifPresent(hobby -> result.put(user, hobby));
        }
        return result;
    }
}