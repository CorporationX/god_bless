package faang.school.godbless.Task_1;

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
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> listMap = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            List<User> list = new ArrayList<>();
            Integer age = users.get(i).getAge();

            for (int j = 0; j < users.size(); j++) {

                if (users.get(j).getAge() == age) {
                    list.add(users.get(j));
                }
            }
            listMap.put(age, list);
        }
        return listMap;
    }
}
