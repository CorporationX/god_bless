package faang.school.godbless.hash_map.hobbyLovers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    @Getter
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> listUser, Set<String> activities) {
        Map<User, String> userMapHobby = new HashMap<>();
        for (User user : listUser) {
            for (String activity : activities) {
                if (user.getHobbies().contains(activity)) {
                    userMapHobby.put(user, activity);
                    break;
                }
            }
        }
        return userMapHobby;
    }
}
