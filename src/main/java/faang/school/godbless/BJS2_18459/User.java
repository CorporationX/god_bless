package faang.school.godbless.BJS2_18459;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> usersGroupedByAgeMap = new HashMap<>();

        for(User user: users) {
            if (usersGroupedByAgeMap.containsKey(user.getAge())) {
                usersGroupedByAgeMap.get(user.getAge()).add(user);
            } else {
                usersGroupedByAgeMap.put(user.getAge(), new ArrayList<>(List.of(user)));
            }
        }
        return usersGroupedByAgeMap;
    }
}
