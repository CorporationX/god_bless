package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
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

    //Перетруться если возраст одинаковый, но наверное это не важно
    public static Map<Long, String> groupUsers(List<User> userList){
        Map<Long, String> map = new HashMap<>();
        for(User u: userList){
            map.put(u.Age,u.Name);
        }
        return map;
    }
}
