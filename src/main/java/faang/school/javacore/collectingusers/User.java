package faang.school.javacore.collectingusers;

import lombok.Getter;

import java.util.*;
@Getter
public class User {
    private long id;
    private String name;
    private int age;
    private Set <String> activities;


    public HashMap findHobbyLovers (List<User> userList, Set <String> setActivities){
        HashMap <User, String> mapActivityUser = new HashMap<>();
        for (User user: userList){
            for (String userActivity: user.getActivities()){
                if (setActivities.contains(userActivity)){
                    mapActivityUser.put(user,userActivity);
                    break;
                }
            }
        }
        return  mapActivityUser;
    }
}
