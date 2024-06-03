package groupusersbyage;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;
    private String jobPlace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
    }
}