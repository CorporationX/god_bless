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
    Set<String> activites = new HashSet<>();

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitesl) {
        Map<User, String> result = new HashMap<>();

        for(var user : users) {
            for(var activity : user.getActivites()) {
                if(activitesl.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }
}
