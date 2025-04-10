package school.faang.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUserByAge(int ageUser, List<User> userAgeList) {
        Map<Integer, List<User>> resultMap = new HashMap<>();
        List<User> ageList = new ArrayList<>();
        for (User userAge : userAgeList) {
            if (ageUser == userAge.getAge()) {
                ageList.add(userAge);
                resultMap.put(ageUser, ageList);
            }
        }
        return resultMap;
    }
}
