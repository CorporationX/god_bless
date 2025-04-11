package school.faang.hobby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbyUsers;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> hobbies) {
        Map<User, String> resultMap = new HashMap<>();
        for (User user : usersList) {
            for (String hobby : hobbies) {
                if (user.getHobbyUsers().contains(hobby)) {
                    resultMap.put(user, hobby);
                }
            }
        }
        return resultMap;
    }
}
