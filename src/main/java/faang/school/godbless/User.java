package faang.school.godbless;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class User {
    private final int id;
    private String name;
    private int age;
    private HashSet<String> activities = new HashSet<>();

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setActivities(String[] activities){
        for (String activity : activities){
            this.activities.add(activity);
        }
    }

    public HashSet<String> getActivities() {
        return activities;
    }

    public static Map<User, String> findHobbyLovers(HashSet<User> usersList, HashSet<String> targetActivities){
        Map<User, String> matchedUsers = new HashMap<>();
        for (User user : usersList){
            for (String activity : user.getActivities()){
                if (targetActivities.contains(activity)){
                    matchedUsers.put(user, activity);
                    break;
                }
            }
        }
        return matchedUsers;
    }
}
