package school.faang.BJS2_79140;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class User {
    @ToString.Include
    private final String name;
    @Getter
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> inputList) {
        Map<Integer, List<User>> sortedMap = new HashMap<>();

        for (User user : inputList) {
            int age = user.getAge();
            sortedMap.putIfAbsent(age, new ArrayList<>());
            sortedMap.get(age).add(user);
        }
        return sortedMap;
    }
}
