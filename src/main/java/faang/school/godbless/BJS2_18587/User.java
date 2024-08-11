package faang.school.godbless.BJS2_18587;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String company;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        var groupedUsers = new HashMap<Integer, List<User>>();

        for (var user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupedUsers;
    }
}

