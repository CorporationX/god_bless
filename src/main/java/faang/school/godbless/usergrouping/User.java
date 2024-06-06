package faang.school.godbless.usergrouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public record User(String name, Integer age, String placeOfWork, String address) {
    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        return users.stream()
                .collect(groupingBy(User::age));
    }
}
