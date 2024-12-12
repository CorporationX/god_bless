package school.faang.bjs44019;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var ageGroups = new HashMap<Integer, List<User>>();
        for (User user : users) {
            int age = user.age;
            if (!ageGroups.containsKey(age)) {
                ageGroups.put(age, new ArrayList<User>());
            }
            ageGroups.get(age).add(user);
        }
        return ageGroups;
    }
}
