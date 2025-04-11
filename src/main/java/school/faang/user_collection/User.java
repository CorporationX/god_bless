package school.faang.user_collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private final int id;
    private final String name;
    private final int age;
    private Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            user.getActivity().stream()
                    .filter(activities::contains).findFirst()
                    .ifPresent(activity -> hobbyLovers.put(user, activity));
        }
        return hobbyLovers;
    }
}
