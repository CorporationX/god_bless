package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> userList, Set<String> hobbies) {
        Map<User, String> usersHobbies = new HashMap<>();
        for (User user : userList) {
            for (String activity : user.activities) {
                if (hobbies.contains(activity)) {
                    usersHobbies.put(user, activity);
                    break;
                }
            }
        }
        return usersHobbies;
    }
}
