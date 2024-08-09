package faang.school.godbless.task18606;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    @Getter
    private Integer age;
    private String firm;
    private String address;



    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        return map = users.stream().collect(Collectors.groupingBy(User::getAge));

    }
}
