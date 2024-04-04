package faang.school.godbless.UsersCollection;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
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
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities){
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (activities.contains(activity)){
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }

    public static void printHobbyLovers(Map<User, String> map){
        for (Map.Entry<User, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
