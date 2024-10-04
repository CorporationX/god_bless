package school.faang.collest.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetHobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (targetHobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }
}
