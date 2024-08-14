package collectUsers;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String firstName;
    private int age;
    private String companyName;
    private String address;

    public User(String firstName, int age, String companyName, String address) {
        this.firstName = firstName;
        this.age = age;
        this.companyName = companyName;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            group.computeIfAbsent(user.getAge(), usersByAge -> new ArrayList<>()).add(user);
        }
        return group;
    }

}
