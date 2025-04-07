package school.faang.Group_Users_By_Age;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList){
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user: userList){
            if (!mapUser.containsKey(user.getAge())){
                List<User> users = new ArrayList<>();
                mapUser.put(user.getAge(), users);
            }

            mapUser.get(user.getAge()).add(user);
        }

        return mapUser;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
