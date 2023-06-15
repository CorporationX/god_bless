package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

}
