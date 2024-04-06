package faang.school.godbless.collect_users;

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
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.activities) {
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public String getName() {
        return name;
    }
}
