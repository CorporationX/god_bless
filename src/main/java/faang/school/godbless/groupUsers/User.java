package faang.school.godbless.groupUsers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workCompanyName;
    private String homeAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        return usersList.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
