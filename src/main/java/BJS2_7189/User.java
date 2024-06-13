package BJS2_7189;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public record User(int id, String name, int age, Set<String> hobbies) {

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> userHobbies = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if (user.hobbies.contains(activity)) {
                    userHobbies.put(user, activity);
                }
            }
        }
        return userHobbies;
    }
}
