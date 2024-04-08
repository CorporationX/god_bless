package collectingUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class User {
    private int id;
    private String name;
    private int age;
    private HashSet<String> activities;

    public User(int id, String name, int age, HashSet<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static HashMap<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> activitiesSet) {

        HashMap<User, String> resultMap = new HashMap<User, String>();

        for (User user : users) {
            for (String activity : user.activities) {
                if (activitiesSet.contains(activity)) {
                    resultMap.put(user, activity);
                }
            }
        }

        return resultMap;

    }

}
