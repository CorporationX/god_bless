package Task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        for(User user : users){
            if(map.containsKey(user.getAge())){
                List<User> list = map.get(user.getAge());
                list.add(user);
                map.put(user.getAge(), list);
            }else{
                List<User> list = new ArrayList<>();
                list.add(user);
                map.put(user.getAge(),list);
            }
        }
        return map;
    }
}
//ключем будет возраст значение список пользователей с одним возрастом