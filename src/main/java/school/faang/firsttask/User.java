package school.faang.firsttask;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
    private Integer id;

    @ToString.Include
    private String name;
    private  Integer age;

    @Getter
    private Set<String> activities;

    public User(Integer id, String name, Integer age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> usersWithActivities = new HashMap<>();
        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (targetActivities.contains(activity)) {
                    usersWithActivities.put(user, activity);
                    break;
                }
            }
        }
        return usersWithActivities;
    }
}
