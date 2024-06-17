package faang.school.godbless.javaCore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUserByAgeMap = new HashMap<>();
        userList.forEach(user -> groupUserByAgeMap.computeIfAbsent(user.getAge(), v -> new ArrayList<>()).add(user));
        return groupUserByAgeMap;
    }
}
