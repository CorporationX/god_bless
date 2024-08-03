package faang.school.godbless;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        return users.stream().collect(Collectors.groupingBy(u -> u.getAge()));
    }
}