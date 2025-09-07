package school.faang.bjs2_85476;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.hobbies) {
                if (activities.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}