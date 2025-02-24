package school.faang.bjs244002;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    private Long id;
    private String name;
    private Integer age;
    @Getter
    private List<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            List<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

}
