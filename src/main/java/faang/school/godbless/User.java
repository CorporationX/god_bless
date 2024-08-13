package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> hobbyLovers) {
        Map<User, String> hobbyLoversMap = new HashMap<>();
        for (User user : users) {
            for (String hobbyLover : hobbyLovers) {
                if (user.getActivities().contains(hobbyLover)) {
                    hobbyLoversMap.put(user, hobbyLover);
                    break;
                }
            }
        }
        return hobbyLoversMap;
    }
}
