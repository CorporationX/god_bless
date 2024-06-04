package faang.school.godbless.BJS2_7570;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workAddress;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(user -> user.getAge()));
    }
}
