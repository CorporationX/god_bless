package faang.school.godbless.usergrouping;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;

@AllArgsConstructor
public class User {
    private final String name;
    private final Integer age;
    private final String placeOfWork;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return emptyMap();
    }
}
