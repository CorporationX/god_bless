package faang.school.godbless.CollectionUsers;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
public class User {
    protected int id;
    String name;
    protected int age;
    protected String[] userActivities;

    public static Map<User, String> findHobbyLovers(List<User> users, String[] activities) {
        Map<User, String> collectionUserByHobby = new HashMap<>();
        for (User user : users) {
            for (String active : user.userActivities) {
                if (Arrays.asList(activities).contains(active)) {
                    collectionUserByHobby.put(user, active);
                }
            }
        }
        return collectionUserByHobby;
    }
}
