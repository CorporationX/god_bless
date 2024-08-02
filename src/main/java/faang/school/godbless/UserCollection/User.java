package faang.school.godbless.UserCollection;

import lombok.Getter;

import java.util.*;

@Getter
public class User {

    private String name;
    private int age;
    private String address;
    private String job;
    private Set<String> activities;

    public User(String name, int age, String address, String job, Set<String> activities) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
        this.activities = activities;
    }

    public static Map<User, String> getHobbyLovers(List<User> users, Set<String> requiredActivities)
    {
        Map<User, String> activityLovers = new HashMap<User, String>();
        users.forEach(user ->
        {
            for(String requiredActivity : requiredActivities)
            {
                if(user.getActivities().contains(requiredActivity)) {
                    activityLovers.put(user, requiredActivity);
                    break;
                }
            }
        });
        return activityLovers;
    }

    //Для теста в Main
    @Override
    public String toString() {
        return name;
    }
}
