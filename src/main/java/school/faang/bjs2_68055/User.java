package school.faang.bjs2_68055;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
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

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : userList) {
            Set<String> intersection = new HashSet<>(user.getActivities());
            intersection.retainAll(activities);

            if (!intersection.isEmpty()) {
                result.put(user, String.join(", ", intersection));
            }
        }

        return result;
    }
}