package faang.school.godbless.BJS2_18381;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String name;
    private Set<String> activites = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> generalActivities) {
        Map<User, String> usersWithGeneralActivities = new HashMap<>();

        for(var user : users) {
            for(var activity : user.getActivites()) {
                if(generalActivities.contains(activity)) {
                    usersWithGeneralActivities.put(user, activity);
                    break;
                }
            }
        }

        return usersWithGeneralActivities;
    }
}
