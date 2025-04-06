package school.faang.agegrouping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Related to JIRA ticket: BJS2-68095
 */
@AllArgsConstructor
@ToString
@Getter
public class User {
    private final String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupedByAgeUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}