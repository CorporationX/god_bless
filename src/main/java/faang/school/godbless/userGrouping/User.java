package faang.school.godbless.userGrouping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Builder
public class User {

    private String name;
    private Integer age;
    private String jobCompany;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsersByAge = new HashMap<>();

        if (users == null || users.isEmpty()) {
            return groupUsersByAge;
        }

        groupUsersByAge = users
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(User::getAge));

        return  groupUsersByAge;
    }
}
