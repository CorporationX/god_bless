package school.faang.Group_Users_By_Age;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapUser = new HashMap<>();
        for (User user : userList) {
            mapUser.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return mapUser;
    }
}
