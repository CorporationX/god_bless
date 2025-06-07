package school.faang.bjs279138;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(User::getAge));
    }
}


