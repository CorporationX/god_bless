package school.faang.collect_users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activityes) {
        Map<User, String> usersGroup = new HashMap<>();

        for (User user : users) {
            for (String activity : activityes) {
                if (user.getActivity().contains(activity)) {
                    usersGroup.put(user, activity);
                }
            }
        }
        return usersGroup;
    }
}