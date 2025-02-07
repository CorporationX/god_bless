package school.faang.group_users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    Map<Integer, List<User>> groupUsers(List<User> users) {

        // Integer - возраст
        // List - список всех пользователей из исходного списка с этим возрастом

        var mapUsers = new HashMap<Integer, List<User>>();
        //var listUsers = new ArrayList<User>();

        for (User user : users) {

            mapUsers.putIfAbsent(user.getAge(), new ArrayList<>(List.of(user)));

            //mapUsers.get(listUsers)
            //mapUsers.put(user.getAge(), )
        }

        return mapUsers;
    }
}
