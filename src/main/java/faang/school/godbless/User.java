package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class User {
    private long id;
    private String name;
    private int age;
    private List<String> activity;

    public Map<User, String> findHobbyLovers(List<User> users, List<String> activity) {
        Map<User, String>
    }

    public void toString() {
        System.out.println(this.id + ", name: " + this.name + ", age: " + this.age + ", activity: " + this.activity);
    }
}