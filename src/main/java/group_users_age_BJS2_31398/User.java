package group_users_age_BJS2_31398;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class User {
    private String name;
    private int age;
    private String company;
    private String address;


    public static Map <Integer, List<User>> groupUsers (List<User> users) {
        Map<Integer, List<User>> ageGroupList = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!ageGroupList.containsKey(age)) {
                ageGroupList.put(age, new ArrayList<>());
            }
            ageGroupList.get(age).add(user);
        }

return ageGroupList;
    }
}

