package faang.school.godbless.groupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap();
        for (User user: users) {
            int key = user.getAge();
            groupUsers.putIfAbsent(key, new ArrayList<>());
            groupUsers.get(key).add(user);
        }

        return groupUsers;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + job + '\'' +
                ", adress='" + address;
    }
}
