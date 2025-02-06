package bjs256438;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Getter
@ToString
public class User {
    private String name;
    private Integer age;
    private String workPlace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
    }
}