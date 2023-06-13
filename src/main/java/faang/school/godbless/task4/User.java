package faang.school.godbless.task4;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class User {

    private int id;

    private String name;

    private int age;

    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
            for (User user : users) {
                for (String activity : activities) {
                    if (user.getActivities().contains(activity)) {
                        hobbyLovers.put(user, activity);
                        break;
                    }
                }
            }
        return hobbyLovers;
    }
}
