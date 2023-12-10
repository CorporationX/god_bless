package faang.school.godbless.collectUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
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
    Set<String> activities;

    static Map<User, String> findHobbyLovers(List<User> usersList, List<String> activities){
        Map<User, String> hobbyLovers = new HashMap<>();
        Iterator<User> iterator = usersList.iterator();
        while (iterator.hasNext()){
            User  user = iterator.next();
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities){
                if (activities.contains(activity)){
                    hobbyLovers.put(user,activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}
