package school.faang.BJS2_68344;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private Integer age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAge = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            if (!groupedByAge.containsKey(age)) {
                groupedByAge.put(age, new ArrayList<>());
            }
            groupedByAge.get(age).add(user);
        }

        return groupedByAge;
    }
}