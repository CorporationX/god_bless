package faang.school.godbless.domain;

import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class User {

    String name;
    Integer age;
    String placeWork;
    String address;

    public static Map<Integer, List<User>> getGroupUsers(List<User> users) {
        return users.stream()
            .collect(Collectors.toMap(user -> user.age, user -> users, (userList, userListMerge) -> userListMerge));
    }
}
