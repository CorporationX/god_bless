package task4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> setOfActivities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbies) {
        Map<User, String> hobbyMap = new HashMap<>();

        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getSetOfActivities().contains(hobby)) {
                    hobbyMap.put(user, hobby);
                    break;
                }
            }
        }

        return hobbyMap;
    }
}
