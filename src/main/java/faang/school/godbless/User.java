package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> grouped = new HashMap<>();
        for (User user : users) {
            grouped.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return grouped;
    }
}