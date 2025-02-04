package school.faang.usergrouping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    @NonNull
    private final String name;
    private final int age;
    @NonNull
    private final String workplace;
    @NonNull
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users.isEmpty()) {
            return new HashMap<>();
        }
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        users.forEach(user -> groupedUsers
                .computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return groupedUsers;
    }
}
