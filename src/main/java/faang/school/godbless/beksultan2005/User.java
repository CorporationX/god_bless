package faang.school.godbless.beksultan2005;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> result = new HashMap<>();

        for(User user : users){
            if(result.containsKey(user.age)){
                result.get(user.age).add(user);
            }else{
                result.put(user.age, new ArrayList<>(Arrays.asList(user)));
            }
        }
        return result;
    }

    //return users.stream().collect(Collectors.groupingBy(User::getAge));
}
