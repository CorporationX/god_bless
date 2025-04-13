package school.faang.hobbyes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
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
    private Set<String> hobbyes;


    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> manyActions) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbyes()) {
                if (manyActions.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }


}