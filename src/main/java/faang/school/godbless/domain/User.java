package faang.school.godbless.domain;

import lombok.Value;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Value
public class User {

    String name;
    Integer age;
    String placeWork;
    String address;

    public static Map<Integer, List<User>> getGroupUsers(List<User> users) {
        return Objects.isNull(users) ? Collections.emptyMap() : users.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(User::getAge));
    }
}
