package faang.school.godbless.Sprint2_task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String corporation;
    private String address;

    public User(String name, int age, String corporation, String address) {
        this.name = name;
        this.age = age;
        this.corporation = corporation;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.age;
            if (groupMap.containsKey(user.age)) {
                groupMap.get(userAge).add(user);
            } else {
                List<User> group = new ArrayList<>();
                group.add(user);
                groupMap.put(user.age, group);
            }
        }
        return groupMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", corporation='" + corporation + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
