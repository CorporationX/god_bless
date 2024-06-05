package faang.school.godbless.user;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record User(String name, Integer age, String workPlace, String address) {
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::age));
    }
}
