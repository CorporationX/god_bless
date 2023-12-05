package faang.school.godbless.groupUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (groupedUsers.containsKey(user.getAge())) {
                groupedUsers.get(user.getAge()).add(user);
            } else {
                groupedUsers.put(user.getAge(),new ArrayList<>());
                groupedUsers.get(user.getAge()).add(user);
            }
        }
    return groupedUsers;
    }

    @Override
    public String toString() {
        return name;
    }
}