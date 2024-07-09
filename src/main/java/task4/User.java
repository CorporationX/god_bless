package task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> stringSets) {
        Map<User, String> usersHobby = new HashMap<>();
        for (User user : users) {
            for (String s : user.activities) {
                if (stringSets.contains(s)) {
                    usersHobby.put(user, s);
                    break;
                }
            }
        }
        return usersHobby;
    }
}