package faang.school.godbless.users_collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {

        Map<User, String> hobbyLoversMap = new HashMap<>();

        for (User user : users) {
            for (String activity : activities) {
                if(user.getActivities().contains(activity)) {
                    hobbyLoversMap.putIfAbsent(user, activity);
                    break;
                }
            }
        }
        return hobbyLoversMap;
    }

    public static void main(String[] args) {


    }
}
