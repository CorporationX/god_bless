package faang.school.godbless.collectUsers_Task4;

import lombok.Getter;

import java.util.*;

@Getter
public class User {
    private static int userQuantity;
    private int id;
    private String name;
    private int age;
    private Set<String> activities = new HashSet<>();

    public User(String name, int age, Set<String> activities) {
        this.id = userQuantity++;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    private Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> resMap = new HashMap<>();
        for(User user : userList) {
            for(String activity : activities) {
                if(user.getActivities().contains(activity)) {
                    resMap.put(user, activity);
                    break;
                }
            }
        }
        return resMap;
    }
}
