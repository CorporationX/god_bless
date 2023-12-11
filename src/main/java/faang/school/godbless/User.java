package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getActivities()) {
                if (hobbies.contains(hobby))
                    hobbyLovers.put(user, hobby);
            }
            break;
        }
        return hobbyLovers;
    }

    public Set<String> getActivities() {
        return activities;
    }
}
