package faang.school.godbless.BJS2_7177;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities = new HashSet<>();

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> activities){

        Map<User,String> userActivity = new HashMap<>();

        for(User user : users){
            for(String activity : activities){
                if(user.activities.contains(activity)){
                   userActivity.put(user,activity);
                }
            }
        }

        return userActivity;
    }
}
