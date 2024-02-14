package Task1;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;


    public static Map<Integer,List<User>> groupUsers(List<User> usersList){
        Map<Integer, List<User>> groupsUsers = new HashMap<>();
        for (User user : usersList) {
            int age = user.getAge();
            groupsUsers.putIfAbsent(age, new ArrayList<>());
            groupsUsers.get(age).add(user);
        }

        return groupsUsers;

    }


}
