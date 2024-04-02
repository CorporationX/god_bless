package faang.school.godbless.BJS2_4123;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private byte age;
    private Set<String> hobbies;

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.hobbies.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return  result;
    }
}
