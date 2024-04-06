package faang.school.godbless.collecting_users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> userActivities) {
        Map<User, String> mapHobbyLovers = new HashMap<>();

        for (User user : userList) {
            Set<String> activities = user.getActivities();
            for (String activity : activities) {
                if (userActivities.contains(activity)) {
                    mapHobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return mapHobbyLovers;
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

    public Set<String> getActivities() {
        return activities;
    }

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }


}
