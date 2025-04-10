package school.faang.bjs2_68310.user_grouping;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private int id;
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            groupedUsersByAge.putIfAbsent(user.getAge(), new ArrayList<>()).add(user);
        }
        return groupedUsersByAge;
    }
}
