package school.faang.sprint_1.task_bjs244000;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            boolean found = false;
            for (String activity : user.activities) {
                if (hobbies.contains(activity) && !found) {
                    hobbyLovers.put(user, activity);
                    found = true;
                }
            }
        }
        return hobbyLovers;
    }
}
