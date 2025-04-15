package school.faang.sprintone.groupusersbyage;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Data
public class User {
    private String name;
    private int age;
    private String jobName;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers) {
        return listUsers.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
