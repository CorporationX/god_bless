package school.faang.bjs243850.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private String name;
    private String workplace;
    private String address;
    private int age;

    /**
     * Возвращает Map‹Integer, List‹User››,
     * где: ключ — возраст пользователя; значение — список всех пользователей из исходного списка с этим возрастом.
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
