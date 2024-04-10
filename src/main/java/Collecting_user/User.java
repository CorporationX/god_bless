package Collecting_user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : userList) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "Name – " + name;
    }
}