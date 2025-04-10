package school.faang;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record User(String name, int age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::age, LinkedHashMap::new, Collectors.toList()));
    }
}