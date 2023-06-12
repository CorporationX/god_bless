package task1;

import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers (List<User> userList) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User i : userList) {
            int age1 = i.getAge();
            map.putIfAbsent(age1, new ArrayList<>());
            map.get(age1).add(i);
        }
        return map;
    }
}
