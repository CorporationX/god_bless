package faang.school.godbless.sprint2.classes;

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
    private String jobLocate;
    private String address;

    public static Map<Integer, List<User>> groupUser (List<User> list){
        Map<Integer, List<User>> userListMap = new HashMap<>();
        for (User user : list){
            int age = user.getAge();
            if (!userListMap.containsKey(age)){
                userListMap.put(age, new ArrayList<>());
            }
            userListMap.get(age).add(user);
        }
        return userListMap;
    }
}
