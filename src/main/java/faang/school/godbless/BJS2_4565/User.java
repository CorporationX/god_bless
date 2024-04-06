package faang.school.godbless.BJS2_4565;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String jobPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for(User user: users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}
