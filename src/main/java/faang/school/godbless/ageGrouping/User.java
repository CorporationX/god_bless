package faang.school.godbless.ageGrouping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAgeUsers = new HashMap<>();

        for(User user : users) {
            groupedByAgeUsers.compute(user.age, (key, value) ->  {
                if(value == null) {
                    List<User> newUsers = new ArrayList<>();
                    newUsers.add(user);

                    return newUsers;
                } else {
                    value.add(user);

                    return value;
                }
            });
        }

        return  groupedByAgeUsers;
    }
}
