package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activity;

    public User(int id, String name, int age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> resultMap = new HashMap<>();
        users.stream().forEach(user -> {
            activity.stream().forEach(hobby -> {
                if (user.getActivity().contains(hobby)) {
                    resultMap.put(user, hobby);
                }
            });
        });
        return resultMap;
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

}
