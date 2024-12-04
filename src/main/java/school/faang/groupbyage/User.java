package school.faang.groupbyage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> resultList = new HashMap<>();

        for (User user : usersList) {
            if (!resultList.containsKey(user.getAge())) {
                resultList.put(user.getAge(), new ArrayList<>());
            }
            List<User> peers = resultList.get(user.getAge());
            peers.add(user);
            resultList.put(user.getAge(), peers);
        }
        return resultList;
    }

}
