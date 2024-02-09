package faang.school.godbless;

import lombok.Getter;

import java.util.*;

public class User {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for(User user: users){
        Set<String>userActivities=user.getActivities();
            for(String activity: userActivities){
                if(activities.contains(activity)){
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public static void main(String[] args) {
            ///main method fill left
    }
}
