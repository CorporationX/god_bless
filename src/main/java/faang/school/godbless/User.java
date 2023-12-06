package faang.school.godbless;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new TreeMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.getAge())) {
                groupUsers.put(user.getAge(), new ArrayList<>());
            }
            groupUsers.get(user.getAge()).add(user);
        }
        return groupUsers;
    }
}