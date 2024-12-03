package school.faang.sprint_1.task_bjs243928;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public record User(String name, Integer age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> input) {
        if (input == null) {
            return null;
        }
        return input.stream().collect(groupingBy(User::age));
    }
}
