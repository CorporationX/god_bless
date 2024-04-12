package faang.school.godbless.groupusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

import static java.util.stream.Collectors.groupingBy;

@AllArgsConstructor
@Data
public class User {
    private final String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        return list.stream()
                .collect(groupingBy(User::getAge));
    }
}