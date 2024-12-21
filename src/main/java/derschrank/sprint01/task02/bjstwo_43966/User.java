package derschrank.sprint01.task02.bjstwo_43966;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private Set<Activity> activities;

    public static Map<User, Activity> findHobbyLovers(List<User> users, Set<Activity> activitiesToSearch) {
        Map<User, Activity> mapOfUsersWithActivity = new HashMap<>();
        for (User user : users) {
            for (Activity oneOfActivityOfUser : user.activities) {
                if (activitiesToSearch.contains(oneOfActivityOfUser)) {
                    mapOfUsersWithActivity.put(user, oneOfActivityOfUser);
                    break;
                }
            }
        }
        return mapOfUsersWithActivity;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (age: %d) has activities: %s",
                id, name, age, activities);
    }
}
