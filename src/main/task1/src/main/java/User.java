import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for(User user : users){
            if(!groupedUsers.containsKey(user.getAge())){
                List<User> addFirstUser= new ArrayList<>();
                addFirstUser.add(user);
                groupedUsers.put(user.getAge(), addFirstUser);
            } else {
                List<User> addOtherUsers = groupedUsers.get(user.getAge());
                addOtherUsers.add(user);
                groupedUsers.put(user.getAge(), addOtherUsers);
            }
        }
        return groupedUsers;
    }
}
