package school.faang.bjs_85532;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Setter
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;



    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        return users.stream()
                .collect((Collectors
                        .groupingBy(User::getAge, Collectors
                                .toList())));
    }
}
