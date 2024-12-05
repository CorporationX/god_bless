package school.faang.sprint1.task44014collectuser;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Set<String> activity;

    public static Set<User> users = new HashSet<>();

    public static Map<User, String> findHobbyLovers(Set<User> users, Set<String> setActivity) {
        Map<User, String> usersHobby = new HashMap<>();
        for (User user : users) {
            for (String interestActivity : setActivity) {
                if (user.activity.contains(interestActivity)) {
                    usersHobby.put(user, interestActivity);
                    break;
                }
            }
        }
        return usersHobby;
    }

}
