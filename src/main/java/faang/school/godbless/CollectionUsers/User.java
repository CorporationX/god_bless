package faang.school.godbless.CollectionUsers;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> collectionUserByHobby = new HashMap<>();
        for (User user : users) {
            for (String active : user.userActivities) {
                if (activities.contains(active)) {
                    collectionUserByHobby.put(user, active);
                    break;
                }
            }
        }
        return collectionUserByHobby;
    }
}
