package school.faang.bjs2_79164;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAgeUsers = new HashMap<>();

        for (User user : users) {
            groupedByAgeUsers.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }

        return groupedByAgeUsers;
    }

}
