package User_Registration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static HashMap<Integer, List<User>> groupUsers(List<User> userList) {
        HashMap<Integer, List<User>> userMap = new HashMap<>();
        for (User user : userList) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }
            userMap.get(user.getAge()).add(user);
        }
        return userMap;
    }
}