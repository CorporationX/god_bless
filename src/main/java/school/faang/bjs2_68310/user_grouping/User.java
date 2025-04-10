package school.faang.bjs2_68310.user_grouping;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
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
            groupedUsersByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsersByAge.get(user.getAge()).add(user);
        }
        return groupedUsersByAge;
    }
}
