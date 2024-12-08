package school.faang.task_44035;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> result = users.stream().collect(Collectors.groupingBy(User::getAge));
        return result;
    }
}
