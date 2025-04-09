package school.faang.collectUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String[] activitiesList;

    public Map<String, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<String, String> hobbyLobersMap = new HashMap<>();
        for (User user : users) {
            for (String activity : activities) {
                if (user.isHobbyPresent(activity)) {
                    hobbyLobersMap.put(user.name, activity);
                    break;
                }
            }
        }
        return hobbyLobersMap;
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