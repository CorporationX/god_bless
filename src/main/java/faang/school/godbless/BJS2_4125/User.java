package faang.school.godbless.BJS2_4125;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private byte age;
    private String job;
    private String address;

    public static Map<Byte, List<User>> groupUsersByAge(List<User> users) {
        Map<Byte, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}
