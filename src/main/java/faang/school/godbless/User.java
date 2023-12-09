package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private String Name;
    private Long Age;
    private String WorkName;
    private String Address;

    public static Map<Long, List<User>> groupUsers(List<User> userList){
        Map<Long, List<User>> map = new HashMap<>();
        for(User u: userList){
            if(map.containsKey(u.getAge())){
                map.get(u.getAge()).add(u);
            }else{
                List<User> users = new ArrayList<>();
                users.add(u);
                map.put(u.getAge(),users);
            }
        }
        return map;
    }
}
