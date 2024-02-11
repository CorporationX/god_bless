package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@EqualsAndHashCode
@Setter
@Getter
public class User {
    private static int idNum = 0;
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    User(String name, int age, Set<String> activity) {
        setId(idNum++);
        setActivity(activity);
        setAge(age);
        setName(name);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> userActivity = new HashMap<>();

        for (User usFor : users) {
            for (String activUsFor : usFor.activity) {
                    if (activity.contains(activUsFor)) {
                        userActivity.put(usFor, activUsFor);
                        break;
                    }
                }
            }
        return userActivity;
    }
}