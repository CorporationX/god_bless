package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String adress;


    public static Map<Integer, List<User>> groupUsers(List<User> listOfUsers) throws Exception {
        Map<Integer, List<User>> result = new HashMap<>();

        if (listOfUsers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (User user : listOfUsers) {
            if(!result.containsKey(user.getAge())){
                result.put(user.getAge(), new ArrayList<>());
            }

            result.get(user.getAge()).add(user);
        }

        return result;
    }
}
