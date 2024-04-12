package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public static Map<@NonNull Integer,@NonNull List<User>> groupUsers(List<@NonNull User> users){
        Map<Integer,List<User>> mapGroupUsers= new HashMap<>();
        for (User user : users) {
            int age = user.age;
            if(mapGroupUsers.containsKey(age)){
                mapGroupUsers.get(age).add(user);
            } else {
                List<User> newList= List.of(user);
                mapGroupUsers.put(age,newList);
            }
        }
        return mapGroupUsers;
    }
}
