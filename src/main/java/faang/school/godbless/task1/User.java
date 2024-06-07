package faang.school.godbless.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
        private String name;
        private Integer age;
        private String workPlace;
        private String address;

        public static Map<Integer, List<User>> groupUser(List<User> users) {
                Map<Integer, List<User>> result = new HashMap<>();
                for (User user : users) {
                        result.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
                }
                return result;
        }
}
