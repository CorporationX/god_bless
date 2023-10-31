package faang.school.godbless.task4;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    private static Map<User, String> usersMap;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String > findHobbyLovers(List<User> users, Set<String> activities){
        for (User user: users){
            for(String activity: activities){
                if (user.getActivities().contains(activity)){
                    usersMap.put(user, activity);
                    break;
                }
            }
        }
        return usersMap;
    }
}
