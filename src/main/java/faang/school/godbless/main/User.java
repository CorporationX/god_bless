package faang.school.godbless.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            List<String> currentUserActivities = user.getActivities();
            for (String activity : currentUserActivities) {
                if (activities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }
}
