package school.faang.bjs2_31599;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private Integer age;
    private String jobLocation;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        if (userList == null) {
            throw new IllegalArgumentException("The passed list cannot be null");
        }

        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();

        for (User user : userList) {
            if (user == null) {
                continue;
            }
            groupedUsersByAge.putIfAbsent(user.age, addToListUserByAge(userList,user));
        }
        return groupedUsersByAge;
    }

    private static List<User> addToListUserByAge(List<User> userList, User user) {
        List<User> ageGroupUsers = new ArrayList<>();

        for (User userForGroup : userList) {
            if (userForGroup == null) {
                continue;
            }
            if (Objects.equals(user.age, userForGroup.age)) {
                ageGroupUsers.add(userForGroup);
            }
        }
        return ageGroupUsers;
    }
}
