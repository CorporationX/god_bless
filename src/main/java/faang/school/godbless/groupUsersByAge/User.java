package faang.school.godbless.groupUsersByAge;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static HashMap<Integer, List<User>> groupUsers(List<User> list) {
        return (HashMap<Integer, List<User>>) list.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
