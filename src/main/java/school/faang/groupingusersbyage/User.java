package school.faang.groupingusersbyage;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {
        Map<Integer, List<User>> mapUserByAge = new HashMap<>();

        for (User user : listUser) {
            int ageUser = user.getAge();
            mapUserByAge.putIfAbsent(ageUser, new ArrayList<>());
            mapUserByAge.get(ageUser).add(user);
        }
        return mapUserByAge;
    }
}
