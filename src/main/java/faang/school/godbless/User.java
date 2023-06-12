package faang.school.godbless;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
