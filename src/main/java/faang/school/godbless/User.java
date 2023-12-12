package faang.school.godbless;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(Long id, String name, int age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity != null ? new HashSet<>(activity) : new HashSet<>();
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> actives) {
        Map<User, String> hobbyLover = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivity()) {
                if (actives.contains(activity)) {
                    hobbyLover.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLover;
    }
}