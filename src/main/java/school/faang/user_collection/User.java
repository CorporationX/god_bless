package school.faang.user_collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            user.getActivity().stream()
                    .filter(activities::contains)
                    .findFirst()
                    .ifPresent(activity -> hobbyLovers.put(user, activity));
        }
        return hobbyLovers;
    }
}
