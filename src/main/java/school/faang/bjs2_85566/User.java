package school.faang.bjs2_85566;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

@AllArgsConstructor
@ToString

public class User {
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Objects.requireNonNull(users, "users cannot be null");
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}
