package school.faang.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;


    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            String commonActivity = findFirstCommonActivity(user.getActivities(), hobbies);

            if (commonActivity != null) {
                result.put(user, commonActivity);
            }
        }

        return result;
    }

    private static String findFirstCommonActivity(Set<String> userActivities, Set<String> hobbies) {
        for (String activity : userActivities) {
            if (hobbies.contains(activity)) {
                return activity;
            }
        }
        return null;  // если общих активностей нет
    }
}

