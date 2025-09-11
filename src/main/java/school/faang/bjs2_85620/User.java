package school.faang.bjs2_85620;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String address;
    private String workplace;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new LinkedHashMap<>();

        for (User user : users) {
            map.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return map;
    }
}