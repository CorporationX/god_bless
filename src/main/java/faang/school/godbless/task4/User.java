package faang.school.godbless.task4;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    result.put(user, hobby);
                }
            }
        }
        return result;
    }
}
