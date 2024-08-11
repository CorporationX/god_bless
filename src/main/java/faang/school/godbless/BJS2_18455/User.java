package faang.school.godbless.BJS2_18455;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        HashMap<User, String> usersHobbies = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (activities.contains(activity)) {
                    usersHobbies.put(user, activity);
                    break;
                }
            }
        }
        return usersHobbies;
    }
}
