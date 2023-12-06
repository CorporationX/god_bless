package faang.school.godbless.groupUsersByAge;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    @Getter
    private int age;
    private String work;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.putIfAbsent(user.getAge(), new ArrayList<>(Arrays.asList()));
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return name;
    }
}