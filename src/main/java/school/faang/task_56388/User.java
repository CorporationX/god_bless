package school.faang.task_56388;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    @NonNull
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : users) {
            usersGroupedByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return usersGroupedByAge;
    }
}
