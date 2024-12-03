package school.faang.task_43921;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    @Override
    public String toString() {
        return "name='" + name + "', age=" + age + ", workplace='" + workplace + "', address='" + address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
