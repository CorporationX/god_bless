package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private String name; // имя пользователя;
    private int age; // возраст пользователя;
    private String workplace; // место работы пользователя;
    private String address; // адрес пользователя.
    public static Map<Integer,List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new TreeMap<>();
        for(User user : users) {
            if(!map.containsKey(user.getAge())) {
                map.put(user.getAge(), new ArrayList<>());
            }
            map.get(user.getAge()).add(user);
        }
return map;

    }
}
