package faang.school.godbless.collerctions_user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;
    private int age;
    private HashSet<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, HashSet<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    hobbyLovers.put(user, activity);
                }
            }
        }
        return hobbyLovers;
    }
}
