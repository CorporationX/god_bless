package school.faang.sprint1.task_43997;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    /**
     * @param users list representing users that need to be grouped by age
     * @return map representing users grouped by their age
     * @throws IllegalArgumentException if the <b>users</b> is null
     */
    protected static Map<Integer, List<User>> groupUsers(List<User> users) {
        //validation
        if (users == null) {
            throw new IllegalArgumentException("Input list can't be null!");
        }

        //grouping and return
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
