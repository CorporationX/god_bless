package school.faang.grouping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public record User(String name, Integer age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::age));
    }
}
