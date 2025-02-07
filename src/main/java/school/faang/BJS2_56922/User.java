package school.faang.BJS2_56922;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new TreeMap<>();
        if (users.size() == 0) {
            System.out.println("Список пользователей пуст");
        } else {
            for (User user : users) {
                if (!map.containsKey(user.getAge())) {
                    map.put(user.getAge(), new ArrayList<>());
                }
                map.get(user.getAge()).add(user);
            }
        }
        return map;

    }
}
