package faang.school.godbless.GroupingUsers;

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
    private int age;
    private String job;
    private String address;

    /*
    * Time-complexity: O(n), n - кол-во пользователей
    * Space-complexity: O(n), n - кол-во пользователей
    * */
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupingMap = new HashMap<>();
        for(User user : users){
            if(!groupingMap.containsKey(user.getAge())){
                groupingMap.put(user.getAge(), new ArrayList<>());
            }
            groupingMap.get(user.getAge()).add(user);
        }
        return groupingMap;
    }

}
