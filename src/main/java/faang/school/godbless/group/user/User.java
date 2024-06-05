package faang.school.godbless.group.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NonNull
@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            int keyAge = user.getAge();
            usersByAge.computeIfAbsent(keyAge, listBayKey -> new ArrayList<>()).add(user);
        }
        return usersByAge;
    }

    public static void showUsersGroupedByAge(List<User> users) {
        for (Map.Entry<Integer, List<User>> user : groupUsers(users).entrySet()) {
            System.out.println(user);
        }
    }
}
