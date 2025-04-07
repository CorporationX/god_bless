package school.faang;

import lombok.*;

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
            if (!mapUserByAge.containsKey(ageUser)) {
                List <User> innerListUser = new ArrayList<>();
                innerListUser.add(user);
                mapUserByAge.put(user.getAge(),innerListUser);
            } else {
                mapUserByAge.get(ageUser).add(user);
            }
        }
        return mapUserByAge;
    }
}
