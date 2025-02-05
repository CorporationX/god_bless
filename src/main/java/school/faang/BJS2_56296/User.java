package school.faang.BJS2_56296;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbiesLovers = new HashMap<>();
        for(User user: users) {
            for (String hobby : user.getHobbies()) {
                if(hobbies.contains(hobby)) {
                    hobbiesLovers.put(user,hobby);
                    break;
                }
            }
        }
        return hobbiesLovers;
    }


}