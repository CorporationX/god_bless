package school.faang.usercollection;

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
    private Set<HobbyTypes> hobbies;

    public static Map<User, HobbyTypes> findHobbyLovers(List<User> users, Set<HobbyTypes> hobbySet) {
        var result = new HashMap<User, HobbyTypes>();
        for (User user : users) {
            for (HobbyTypes hobby : user.getHobbies()) {
                if (hobbySet.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }
}
