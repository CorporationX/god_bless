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
    private int age;
    private String address;
    private String placeOfWork;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultingUserGroupByAge = new HashMap<>();
        for (User user : users) {
            Integer userAge = user.getAge();
            if (!resultingUserGroupByAge.containsKey(userAge)){
                List<User> userGroup = new ArrayList<>();
                resultingUserGroupByAge.put(userAge,userGroup);
            }
            resultingUserGroupByAge.get(userAge).add(user);
        }
        return resultingUserGroupByAge;
    }
}
