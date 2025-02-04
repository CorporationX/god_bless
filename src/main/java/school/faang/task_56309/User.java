package school.faang.task_56309;
import lombok.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> many_activities;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<User, String>();
        for (User user : users) {
            for (String hobby : activities) {
                if (user.getMany_activities().contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }

        return hobbyLovers;
    }
}
