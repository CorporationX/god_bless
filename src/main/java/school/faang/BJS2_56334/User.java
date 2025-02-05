package school.faang.BJS2_56334;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbiess = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> resultMap = new HashMap<>();
        for (User user : users) {
            for (String hobbi : hobbies) {
                if (user.hobbiess.contains(hobbi)) {
                    resultMap.put(user, hobbi);
                    break;
                }
            }
        }
        return resultMap;
    }
}