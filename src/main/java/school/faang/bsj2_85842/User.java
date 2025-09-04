package school.faang.bsj2_85842;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static Map<Integer, ArrayList<User>> groupUsers(ArrayList<User> userList) {
        Map<Integer, ArrayList<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            ArrayList<User> valueUserList = new ArrayList<>();
            if (groupUsers.get(user.age) != null) {
                valueUserList = groupUsers.get(user.age);
            }
            valueUserList.add(user);
            groupUsers.put(user.age, valueUserList);
        }
        return groupUsers;
    }
}
