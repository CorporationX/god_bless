package users;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User() {
        name = "Nikita";
        age = 27;
        workplace = "Home";
        address = "-";
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = users.stream()
                .collect(Collectors.groupingBy(User::getAge,
                        Collectors.toList()));

        return usersGroupByAge;
    }
}
