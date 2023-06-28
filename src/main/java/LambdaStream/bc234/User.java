package LambdaStream.bc234;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : listUsers) {
            if (!groupedUsers.containsKey(user.getAge())) {
                List<User> newListAdd = new ArrayList<>();
                newListAdd.add(user);
                groupedUsers.put(user.getAge(), newListAdd);
            } else {
                List<User> addOtherUsers = groupedUsers.get(user.getAge());
                addOtherUsers.add(user);
                groupedUsers.put(user.getAge(), addOtherUsers);
            }
        }
        return groupedUsers;
    }
}
