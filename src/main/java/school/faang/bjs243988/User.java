package school.faang.bjs243988;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
public class User {

    private String name;
    @Getter
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            Integer userAge = user.getAge();
            if (!result.containsKey(userAge)) {
                result.put(userAge, new ArrayList<>());
            }
            result.get(userAge).add(user);
        }
        return result;
    }

}
