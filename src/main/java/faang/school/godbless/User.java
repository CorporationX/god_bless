package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private int age;

    private Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> AllActivity) {
        Map<User, String> mapUserActivity = new HashMap<User, String>();

        for (User user : users) {
            Set<String> actUser = user.activity;

            Set<String> resultIntersection = new HashSet<String>(actUser);
            resultIntersection.retainAll(AllActivity);

            if (!resultIntersection.isEmpty()) {
                mapUserActivity.put(user, resultIntersection.iterator().next());
            }

        }

        return mapUserActivity;
    }
}
