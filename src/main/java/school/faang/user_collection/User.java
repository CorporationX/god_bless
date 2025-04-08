package school.faang.user_collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
            Optional<String> matched = user.getActivity().stream()
                    .filter(activities::contains)
                    .findFirst();

            matched.ifPresent(activity -> hobbyLovers.put(user, activity));
        }
        return hobbyLovers;
    }
}
