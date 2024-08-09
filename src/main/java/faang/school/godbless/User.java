package faang.school.godbless;

import java.util.*;

import lombok.AllArgsConstructor;

public class User {
    String name;
    //    String[] activities;
    Set<String> activities = new HashSet<>();
    int id;
    int age;

    public User(String name, Set<String> activities, int id, int age){
        this.name = name;
        this.activities = activities;
        this.id = id;
        this.age = age;
    }
    static Map<User, String> findHobbyLovers(ArrayList<User> users, Set<String> activities){
        Map<User, String> pare = new HashMap<>();
        String currentActivitie;
        User currentUser;

        for (User user : users){
            for(String generalActivities : activities){
                for(String userActivitie : user.activities){
                    if(userActivitie == generalActivities){
                        currentActivitie = userActivitie;
                        currentUser = user;
                        pare.put(currentUser, currentActivitie);
                    }
                }
            }
        }
        return pare;
    }
}