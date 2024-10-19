package school.faang.BJS2_31451;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@ToString
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
