package school.faang.BJS2_85685;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        final Map<Integer, List<User>> groupedMapToReturn = new HashMap<>();
        for (User user : userList) {
            groupedMapToReturn.computeIfPresent(
                    user.getAge(),
                    (key, value) -> {
                        value.add(user);
                        return value;
                    }
            );
            groupedMapToReturn.computeIfAbsent(
                    user.getAge(),
                    key -> new ArrayList<>(Arrays.asList(user))
            );
        }
        return groupedMapToReturn;
    }
}