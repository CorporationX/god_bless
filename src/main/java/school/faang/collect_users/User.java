package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String name;
    private Integer age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        users.forEach(user -> {
                for (String hobby : user.getHobbies()) {
                    if (hobbies.contains(hobby)) {
                        result.put(user, hobby);
                        break;
                    }
                }
            }
        );

        return result;
    }
}
