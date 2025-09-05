package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private int id;
    private Set<String> activities;


    public static HashMap<String, String> findHobbyLovers(List<User> users, List<String> activities) {
        HashMap<String, String> suitableUsersActivities = new HashMap<>();
        for (User user : users) {
            Set<String> common = new HashSet<>(user.activities);
            common.retainAll(activities);

            if (!common.isEmpty()) {
                Iterator<String> it = common.iterator();
                suitableUsersActivities.put(user.name, it.next());
            }
        }

        return suitableUsersActivities;
    }

}
