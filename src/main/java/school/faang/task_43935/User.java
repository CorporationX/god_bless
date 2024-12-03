package school.faang.task_43935;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream()
                .collect(Collectors.groupingBy(user -> user.age));

    }

}
