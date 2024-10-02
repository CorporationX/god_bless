package school.faang;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    private String address;
    private String workPlace;

    public User(String name, int age, String address, String workPlace) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.workPlace = workPlace;
    }



    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}