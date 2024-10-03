package school.faang.usercollection;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    private final long id;
    private final String name;
    private final int age;
    @Getter
    private final Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        HashMap<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities())
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
        }
        return hobbyLovers;
    }
}
