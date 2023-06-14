package Task4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    int id;
    String name;
    int age;
    List<String> setOfActivities;

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
