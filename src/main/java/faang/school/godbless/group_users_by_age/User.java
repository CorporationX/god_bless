package faang.school.godbless.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (Objects.equals(users, null) || users.isEmpty()) {
            throw new IllegalArgumentException("User list is null/empty!");
        }

        Map<Integer, List<User>> usersByAge = new HashMap<>();
        users.forEach(
                user -> usersByAge.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user)
        );

        return usersByAge;
    }

    @Override
    public String toString() {
        return "User: Name[" + this.name + "], age[" + age + "]";
    }
}
