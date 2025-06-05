package school.faang.bjs279181;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter

public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map <User, String> findHobbyLovers (List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String act : activities) {
                if (user.getActivities().contains(act)){
                    result.put(user, act);
                    break;
                }

            }
        }
        return result;
    }

}
