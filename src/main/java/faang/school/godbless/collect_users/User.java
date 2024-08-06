package faang.school.godbless.collect_users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (var user : users) {
            for (var userActivity : user.getActivities()){
                if (activities.contains(userActivity)){
                    hobbyLovers.put(user,userActivity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
