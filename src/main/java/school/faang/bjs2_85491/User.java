package school.faang.bjs2_85491;

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
    private String job;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users, Integer findAge){
        List<User> temp = new ArrayList<>();

        for (User user : users){
            if(user != null && user.getAge() != null && user.getAge().equals(findAge)){
                temp.add(user);
            }
        }
        Map<Integer,List<User>> userGroupByAge = new HashMap<>();
        if(!temp.isEmpty()){
            userGroupByAge.put(findAge, temp);
        }
        return userGroupByAge;
    }

}
