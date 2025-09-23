package school.faang.sprint1.usergrouping;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    /**
     * Group a list of {@link User} by their age.
     *
     * @param users - List of users; may be {@code null} or empty.
     * @return - a mao where a key is the user's age, and the value is a list of all users with this age.
     */
    public static Map<Integer, List<User>> groupUsers(final List<User> users) {
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.stream()
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(User::getAge));
    }

}
