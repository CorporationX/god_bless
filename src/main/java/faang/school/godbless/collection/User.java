package faang.school.godbless.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> userActivities;

    public User(int id, String name, int age, List<String> userActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userActivities = userActivities;
    }

    public List<String> getUserActivities() {
        return userActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, String[] activities){
        Map<User, String> map = new HashMap<>();
        for (User user : users){
            for (String activity : activities){
                if (user.getUserActivities().contains(activity)){
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(userActivities, user.userActivities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, userActivities);
    }
}