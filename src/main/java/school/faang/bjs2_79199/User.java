package school.faang.bjs2_79199;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activite;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activite : user.getActivite()) {
                if (activities.contains(activite)) {
                    result.put(user, activite);
                    break;
                }
            }
        }
        return result;
    }
}