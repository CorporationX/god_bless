package faang.school.godbless.groupusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class User {
    private final String name;
    private Integer age;
    private String company;
    private String address;

    private static List<User> getListOUsersByAge(Integer age, List<User> list) {
        return list.stream()
                .filter(u -> u.getAge().equals(age))
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        return list.stream()
                .collect(Collectors.toMap(User::getAge, u -> getListOUsersByAge(u.getAge(), list)));
    }
}
