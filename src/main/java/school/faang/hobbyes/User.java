package school.faang.hobbyes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private Set<String> manyActions;
    private int id;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> manyActions) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            Set<String> userHobbies = user.getManyActions();
            for (String hobby : userHobbies) {
                if (manyActions.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}