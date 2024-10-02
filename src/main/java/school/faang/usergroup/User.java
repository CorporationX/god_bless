package school.faang.usergroup;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())){
                groupedUsers.put(user.getAge(), new ArrayList<>(){{add(user);}});
            }else{
                groupedUsers.get(user.getAge()).add(user);
            }
        }
        return groupedUsers;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
