package school.faang.collectusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activitiesList;

    public Map<String, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<String, String> hobbyLoversMap = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.isHobbyPresent(activity)) {
                    hobbyLoversMap.put(user.name, activity);
                    break;
                }
            }
        }
        return hobbyLoversMap;
    }

    public boolean isHobbyPresent(String hobby) {
        for (String activity : activitiesList) {
            if (hobby.equals(activity)) {
                return true;
            }
        }
        return false;
    }
}