package faang.school.godbless;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private int id;

    private String name;

    private int age;

    private Set<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> AllActivity) {
        Map<User, String> mapUserActivity = new HashMap<User, String>();

        for (User user: users) {
            Set<String> actUser = user.activity;

            Set<String> result = new HashSet<String>(actUser);
            result.retainAll(AllActivity);

            mapUserActivity.put(user, result.iterator().next());

        }

        return null;
    }
}
