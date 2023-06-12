package faang.school.godbless.group_users;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(@NonNull List<User> usersList) {
        return usersList.stream().filter(item -> item != null).collect(Collectors.groupingBy(User::getAge));
    }

    private int getAge() {
        return age;
    }
}

