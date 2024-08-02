package faang.school.godbless.BJS2_18459;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> result = new HashMap<>();

        for(User user: users) {
            List<User> temp = new ArrayList<>();
            temp.add(user);
            result.merge(user.getAge(), temp, (x, y) -> {
                x.add(y.get(0));
                return x;
            });
        }
        return result;
    }
}
