package school.faang.moduleone.task_43503;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            Optional.ofNullable(result.get(user.getAge()))
                .ifPresentOrElse(
                    it -> it.add(user),
                    () -> {
                        List<User> userList = new ArrayList<>();
                        userList.add(user);
                        result.put(user.getAge(), userList);
                    }
                );
        }
        return result;
    }
}
