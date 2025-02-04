package school.faang.task_56357;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private String username;
    private int age;
    private String workplace;
    private String address;

    public User(String username, int age, String workplace, String address) {
        this.username = username;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            userGroups.putIfAbsent(user.getAge(), new ArrayList<>());
            userGroups.get(user.getAge()).add(user);
        }
        return userGroups;
    }


}
