package faang.school.godbless.groupingUsersByAge;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;



@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String address;
    private String placeOfWork;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultingUserGroupByAge = new HashMap<>();
        for (User user : users) {
            Integer userAge = user.getAge();
            resultingUserGroupByAge.computeIfAbsent(userAge, k -> new ArrayList<>()).add(user);
        }
        return resultingUserGroupByAge;
    }
}
