package faang.school.godbless.domain;


import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activitys;

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

    public Set<String> getActivitys() {
        return activitys;
    }

    public void setActivitys(Set<String> activitys) {
        this.activitys = activitys;
    }

}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public record User(String name, Integer age, String work, String address) {


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.age())) {
                groupUsers.put(user.age(), new ArrayList<>());
                groupUsers.get(user.age()).add(user);
            }
        }
        return groupUsers;
    }
}


