package school.faang.hobby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Users {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbyUsers;

    public static Map<Users, String> findHobbyLovers(List<Users> usersList, Set<String> hobby) {
        Map<Users, String> resultMap = new HashMap<>();
        for (Users users : usersList) {
            for (String elements : hobby) {
                if (users.getHobbyUsers().contains(elements)) {
                    resultMap.put(users, elements);
                }
            }
        }
        return resultMap;
    }
}
