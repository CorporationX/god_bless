package faang.school.godbless;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class User{
    public int id;
    public String name;
    public int age;
    public Set<String> activities;

    public User(int id, String name, int age, Set<String> activities){
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User , String> findHobbyLovers(List<User> userList , Set<String> activities){
        Map<User , String> hobbyLovers = new HashMap<>();
        for(User record : userList){
            for(String activity : activities){
                if(record.activities.contains(activity)){
                    hobbyLovers.put(record , activity);
                }
            }
        }
    return hobbyLovers;
    }
}
