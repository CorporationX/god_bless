package school.faang.usercollector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(int id, String name, int age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "User {id = " + id + ", name = " + name + ", age = " + age + ", activity = " + activity + "}";
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivity()) {
                if (activities.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }
        return map;
    }
}