package faang.school.godbless;

import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@ToString
public class User {
    int id;
    String name;
    int age;
    Set<String> userActivities;

    public User(int id, String name, int age, Set<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public static HashMap<User,String> findHobbyLovers(List<User> users, Set<String> allActivities){
        HashMap<User,String> hobbyLovers = new HashMap<>();

        for(User user : users){
            for(String activity : allActivities){
                if(user.userActivities.contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

}
