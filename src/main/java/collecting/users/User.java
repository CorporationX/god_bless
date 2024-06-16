package collecting.users;

import java.util.Set;

public class User {

    int id;
    String name;
    int age;
    Set<String> activities;

    public User(int id, Set<String> activities, int age, String name) {
        this.id = id;
        this.activities = activities;
        this.age = age;
        this.name = name;
    }
}
