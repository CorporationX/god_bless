package school.faang.task_BJS2_56323;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;


public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public String getName() {
        return name;
    }

    public static Map<String, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<String, String> hobbyLovers = new HashMap<>();
        if (users == null || hobbies == null) {
            return hobbyLovers;
        }
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    hobbyLovers.put(user.getName(), hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}