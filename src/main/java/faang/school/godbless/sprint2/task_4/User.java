package faang.school.godbless.sprint2.task_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activity = new ArrayList<>();

    public User(int id, String name, int age, List activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> activityFiltre) {
        HashMap<User, String> map = new HashMap<>();
        for (User person : users) {
            for (String personactiv : person.activity) {
                if (activityFiltre.contains(personactiv)) {
                    map.put(person, personactiv);
                }
            }
        }
        return map;

    }
}