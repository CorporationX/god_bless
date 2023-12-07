package faang.school.godbless.alexbulgakoff.groupingusersbyage;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alexander Bulgakov
 */
@ToString
public class User {

    private String name;

    private Integer age;

    private String jobName;

    private String address;

    public User(String name, Integer age, String jobName, String address) {
        this.name = name;
        this.age = age;
        this.jobName = jobName;
        this.address = address;
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(user -> user.age));
    }
}
