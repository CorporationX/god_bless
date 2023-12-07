package userCollection;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getActivity() {
        return activity;
    }

    public void setActivity(Set<String> activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activity=" + activity +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> act) {

        Map<User, String> result = new HashMap<>();
        for (User u : users) {
            for (String a : act) {
                if (u.activity.contains(a)) {
                    result.put(u, a);
                    break;
                }
            }
        }
        return result;
    }
}