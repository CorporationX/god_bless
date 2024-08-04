package faang.school.godbless.BJS2_18507;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersGroupsByAge = new HashMap<>();
        for (User user : users) {
            List<User> ageGroup = usersGroupsByAge.getOrDefault(user.getAge(), new ArrayList<>());
            ageGroup.add(user);
            usersGroupsByAge.put(user.getAge(), ageGroup);
        }
        return usersGroupsByAge;
    }
}
