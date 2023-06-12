package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private final String name;
    private int age;
    private List<String> activities;

    public User(String name, int age, List<String> activities) {
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public Map<User, String> findHobbyLovers(User[] users, List<String> activities) {
        HashMap<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String userActivity : user.activities) {
                if (activities.contains(userActivity)) {
                    map.put(user, userActivity);
                }
            }
        }

        return map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
