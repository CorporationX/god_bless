package faang.school.godbless.collectionOfUsers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;



@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "ownActivities")
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> ownActivities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> setActivities) {
        Map<User, String> resultingUserGroupWithMatch = new HashMap<>();
        for (User user : users) {
            Set<String> intersection = new HashSet<>(user.ownActivities);
            intersection.retainAll(setActivities);
            if (!intersection.isEmpty()) {
                resultingUserGroupWithMatch.put(user, intersection.iterator().next());
            }
        }
        return resultingUserGroupWithMatch;
    }
}
