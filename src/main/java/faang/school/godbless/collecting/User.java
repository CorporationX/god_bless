package faang.school.godbless.collecting;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getHobbies().contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
}
