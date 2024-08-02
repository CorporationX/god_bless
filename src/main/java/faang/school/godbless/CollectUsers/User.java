package faang.school.godbless.CollectUsers;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;


    // Time-complexity: O(N * M), где N - кол-во пользователей, M - кол-во активностей пользователя
    // Time-complexity: O(N), где N - кол-во пользователей
    public static HashMap<User, String> findHobbyLovers(List<User> users,
                                                        Set<String> activities)
    {
        HashMap<User, String> groupingMap = new HashMap<>();

        for(User user : users){
            for(String activity : user.getActivities()){
                if(activities.contains(activity)){
                    groupingMap.put(user, activity);
                    break;
                }
            }
        }

        return groupingMap;
    }

}
