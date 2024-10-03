package school.faang.usercollection;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    private final long id;
    private final String name;
    private final int age;
    private final List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        HashMap<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            List<String> commonHobbies = new ArrayList<>(user.activities);
            commonHobbies.retainAll(activities);
            if (!commonHobbies.isEmpty()) {
                hobbyLovers.put(user, commonHobbies.get(0));
            }
        }
        return hobbyLovers;
    }
}
