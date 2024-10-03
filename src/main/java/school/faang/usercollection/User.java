package school.faang.usercollection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@AllArgsConstructor
@Data
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobby()){
                if (hobbies.contains(hobby)){
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLovers;

    }
}
