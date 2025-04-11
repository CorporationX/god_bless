package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
public class User68328 {

    private String name;
    private int age;
    private String placeOfWork;
    private String adress;

    public static Map<Integer, List<User68328>> groupUsers(List<User68328> people) {
        Map<Integer, List<User68328>> usersGroupedByAge = new HashMap<>();
        for (User68328 user : people) {
            int userAge = user.age;
            if (usersGroupedByAge.containsKey(userAge)) {
                List<User68328> peers = usersGroupedByAge.get(userAge);
                peers.add(user);
                usersGroupedByAge.put(userAge, peers);
            } else {
                List<User68328> peers = new ArrayList<>();
                peers.add(user);
                usersGroupedByAge.put(userAge, peers);
            }
        }
        return usersGroupedByAge;
    }
}