package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivity()) {
                if (activities.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }
}
