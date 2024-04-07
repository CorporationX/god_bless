package Task2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
public class User {
    private final String name;
    private int age;
    private String adress;
    private String placeOfWork;

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> users) {
        HashMap<Integer, ArrayList<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())) {
                ArrayList<User> usersOfCertainAge = new ArrayList<>();
                groupedUsers.put(user.getAge(), usersOfCertainAge);
            }
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }
}
