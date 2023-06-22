package grouping_users_by_age;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Getter
@Setter
@Builder
public class Users {
    private String name;
    private Integer age;
    private String PlaceOfWork;
    private String address;

    public static Map<Integer, List<Users>> groupUsers (List<Users> users){
        if(users == null){
            return Map.of();
        }
        Map<Integer, List<Users>> groupedUsers = new HashMap<>();

        for (var user: users){
            groupedUsers.computeIfAbsent(user.age, ArrayList::new).add(user);
        }
        return groupedUsers;
    }
}
