package school.faang.module1.task43503;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public User(String name, Integer age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    private Integer getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }


}
