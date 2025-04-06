package school.faang.BJS2_68051;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> userActivities;

    public static Map<User, String> findHobbyLovers(List<User> userList, List<String> activity) {
        return userList.stream().filter(user -> user.getUserActivities().stream().anyMatch(activity::contains))
                .collect(Collectors.toMap(user -> user, user -> user.getUserActivities()
                        .stream().filter(activity::contains)
                        /*
                        Следующая конструкция родилась, так как я не придумал, как завершить стрим иначе.
                        В логике метода, если пользователь не имеет ни одного совпадения, то он
                        просто не попадает в мапу.
                         */
                        .findFirst().orElse("Activity not found")));
    }
}
