package school.faang.groupingusersbyage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        if (users == null) {
            return new HashMap<>();
        }
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
