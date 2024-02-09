package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

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
                boolean compite = false;
                for (String activFor : activity) {
                    if (activFor.equals(activUsFor)) {
                        userActivity.put(usFor, activUsFor);
                        compite = true;
                        break;
                    }
                }
                if (compite) {
                    break;
                }
            }
        }
        return userActivity;
    }
}