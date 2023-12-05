package faang.school.godbless.BJS2_410;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(String name, int age, Set<String> activities) {
        this.name = name;
        this.age = age;
        this.activities = activities;

        this.id = (long)name.hashCode() + age;
    }

    public static Map<User, String> findHobbyLovers (List<User> userList, Set<String> activitySet) {

        Map <User, String> resultMap = new HashMap<>();

        for (User user : userList) {
            for (String userActivity : user.activities) {
                if (activitySet.contains(userActivity)) {
                    resultMap.put(user, userActivity);
                    break;
                }
            }
        }
        return resultMap;
    }

}
