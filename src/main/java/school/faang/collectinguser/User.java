package school.faang.collectinguser;

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

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }

    private Set<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        
        return result;
    }
}
