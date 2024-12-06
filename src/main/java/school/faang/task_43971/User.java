package school.faang.task_43971;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String addres;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> result = new HashMap<>();
            for (User us : userList){
                if (!result.containsKey(us.getAge())) {
                    result.put(us.getAge(), new ArrayList<>());
                }
                result.get(us.getAge()).add(us);
            }
        return result;
    }
}


