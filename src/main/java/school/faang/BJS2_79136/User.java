package school.faang.BJS2_79136;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private String name;
    private Integer age;
    private String addressWork;
    private String address;

    public static Map<Integer,List<User>> groupUsers(List<User> userList){
        Set<Integer> ageUsers = new HashSet<>();
        for(User user: userList){
            ageUsers.add(user.age);
        }
        Map <Integer,List<User>> groupUsers = new HashMap<>();
        for(Integer age: ageUsers){
            List<User> usersToAge = new ArrayList<>();
            for(User user: userList){
                if(user.getAge() == age){
                    usersToAge.add(user);
                }
            }
            groupUsers.put(age,userList);
        }
        return groupUsers;
    }

}
